package absli.uid.helper.portlet.portlet;

import absli.uid.helper.model.Absli;
import absli.uid.helper.portlet.constants.AbsliUidHelperPortletKeys;

import absli.uid.helper.service.AbsliLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author root324
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AbsliUidHelper",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/uid-helperview.jsp",
		"javax.portlet.name=" + AbsliUidHelperPortletKeys.ABSLIUIDHELPER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AbsliUidHelperPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(AbsliUidHelperPortlet.class);

	private AbsliLocalService _absliLocalService;

	private CounterLocalService counterLocalService;

	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	protected void setAbsliLocalService(AbsliLocalService absliLocalService) {
		_absliLocalService = absliLocalService;
	}

	@Reference(unbind = "-")
	protected void setCounterLocalService(CounterLocalService counterLocalService) { this.counterLocalService = counterLocalService; }

	@Reference(unbind = "-")
	protected void setUserLocalServiceLocalService(UserLocalService userLocalService) { this.userLocalService = userLocalService; }
	public void addUid(ActionRequest request, ActionResponse response) throws PortalException {
		_log.info("Add called");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Absli.class.getName(), request);
		String productName = ParamUtil.getString(request, "product");
		String uid = ParamUtil.getString(request, "uid");
		String agentCode = ParamUtil.getString(request, "agentCode");
		String sourceName = ParamUtil.getString(request, "sourceName");
		boolean discount = ParamUtil.getBoolean(request, "discount");
		String createdBy = ParamUtil.getString(request, "createdBy");
		long id = ParamUtil.getLong(request, "id");
		long userId = serviceContext.getUserId();
		if(id == 0) {
			try {
				id = counterLocalService.increment();
				_log.info("adding");
				Absli absli = _absliLocalService.createAbsli(id);
				User user = userLocalService.getUserById(userId);
				Date now = new Date();
				absli.setUuid(serviceContext.getUuid());
				absli.setUserId(serviceContext.getUserId());
				absli.setGroupId(serviceContext.getScopeGroupId());
				absli.setCompanyId(user.getCompanyId());
				absli.setUserName(user.getFullName());
				absli.setCreateDate(now);
				absli.setModifiedDate(now);
				absli.setExpandoBridgeAttributes(serviceContext);
				absli.setUId(uid);
				absli.setProduct(productName);
				absli.setAgentCode(agentCode);
				absli.setSourceName(sourceName);
				absli.setDiscount(discount);
				absli.setCreatedBy(createdBy);
				_absliLocalService.updateAbsli(absli);
				_log.info(absli.getId());
				request.setAttribute("id", id);
			} catch (Exception e) {
				_log.error(e);
				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter(
						"mvcPath", "uid-helperview.jsp");
			}
		}
		else {
			try {
				_log.info("updating");
				Absli absli =  _absliLocalService.getAbsli(id);
				User user = userLocalService.getUserById(userId);
				long groupId = serviceContext.getScopeGroupId();
				Date now = new Date();
				absli.setUuid(serviceContext.getUuid());
				absli.setUserId(userId);
				absli.setGroupId(groupId);
				absli.setCompanyId(user.getCompanyId());
				absli.setUserName(user.getFullName());
				absli.setModifiedDate(now);
				absli.setExpandoBridgeAttributes(serviceContext);
				absli.setUId(uid);
				absli.setProduct(productName);
				absli.setAgentCode(agentCode);
				absli.setSourceName(sourceName);
				absli.setDiscount(discount);
				absli.setCreatedBy(createdBy);
				_absliLocalService.updateAbsli(absli);
				request.setAttribute("id", id);
			} catch (Exception e) {
				response.setRenderParameter(
						"mvcPath", "uid-helperview.jsp");
				_log.error(e);
			}
		}
		_log.info(productName + " " + agentCode + " " + uid + " " + " " + sourceName + " " + " " + discount + " " + createdBy);

	}
	public void editUid(ResourceRequest request, ResourceResponse response) throws IOException {
		String uId = ParamUtil.getString(request, "uid");
		_log.info(uId + " Edit");
		Absli absli = _absliLocalService.getbyUid(uId);
		JSONArray absliJsonArray = JSONFactoryUtil.createJSONArray();
			JSONObject jsonAbsli = null;
			jsonAbsli = JSONFactoryUtil.createJSONObject();
			jsonAbsli.put("productName", absli.getProduct());
			jsonAbsli.put("uId", absli.getUId());
			jsonAbsli.put("agentCode", absli.getAgentCode());
			jsonAbsli.put("sourceName", absli.getSourceName());
			jsonAbsli.put("discount", absli.getDiscount());
			jsonAbsli.put("createdBy", absli.getCreatedBy());
			jsonAbsli.put("id", absli.getId());
			absliJsonArray.put(jsonAbsli);
		JSONObject tableData = JSONFactoryUtil.createJSONObject();
		tableData.put("data", absliJsonArray);
		_log.info("tableData:" + tableData.toString());
		ServletResponseUtil.write(PortalUtil.getHttpServletResponse(response),
				tableData.toString());
	}


	public void delete(ResourceRequest request, ResourceResponse response) throws IOException {
		String uid = ParamUtil.getString(request, "uid");

		_log.info(uid + " delete Called");
		try {
			_absliLocalService.deleteAbsli(uid);
		} catch (Exception e) {
			_log.error(e);
		}
		ServletResponseUtil.write(PortalUtil.getHttpServletResponse(response),
				"true");
	}

		@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		long id = ParamUtil.getLong(renderRequest, "id");
		_log.info("Id "+ id);
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		String resourceId = resourceRequest.getResourceID();
		_log.info("server resource " + resourceId);
		if(resourceId.equals("delete")) {
			delete(resourceRequest, resourceResponse);
		} else if(resourceId.equals("edit")) {
			editUid(resourceRequest, resourceResponse);
		} else if(resourceId.equals("product")) {
			products(resourceRequest, resourceResponse);
		} else {
			JSONArray allUsersJsonArray = JSONFactoryUtil.createJSONArray();
			ServiceContext serviceContext = null;
			try {
				serviceContext = ServiceContextFactory.getInstance(Absli.class.getName(), resourceRequest);
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			long groupId = serviceContext.getScopeGroupId();
			JSONArray absliJsonArray = JSONFactoryUtil.createJSONArray();
			try {
				JSONObject jsonAbsli = null;

				List<Absli> abslis = _absliLocalService.getAll(groupId);
				for (Absli absli : abslis) {
					jsonAbsli = JSONFactoryUtil.createJSONObject();
					jsonAbsli.put("productName", absli.getProduct());
					jsonAbsli.put("uId", absli.getUId());
					jsonAbsli.put("agentCode", absli.getAgentCode());
					jsonAbsli.put("sourceName", absli.getSourceName());
					jsonAbsli.put("discount", absli.getDiscount());
					jsonAbsli.put("createdBy", absli.getCreatedBy());
					absliJsonArray.put(jsonAbsli);
				}
			} catch (Exception e) {
				_log.error(e);
			}

			JSONObject tableData = JSONFactoryUtil.createJSONObject();
			tableData.put("data", absliJsonArray);
			_log.info("tableData:" + tableData.toString());
			ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse),
					tableData.toString());
		}
	}

	private void products(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		ServiceContext serviceContext = null;
		try {
			serviceContext = ServiceContextFactory.getInstance(Absli.class.getName(), resourceRequest);
		} catch (PortalException e) {
			throw new RuntimeException(e);
		}
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		jsonArray.put("P-1");
		jsonArray.put("P-2");
		jsonArray.put("P-3");
		jsonArray.put("Product-1");
		jsonArray.put("Product-2");
		jsonArray.put("Product-3");
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("data", jsonArray);
		ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse),
				jsonObject.toString());
	}
}
