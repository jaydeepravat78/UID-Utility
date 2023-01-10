<%@ taglib prefix="portet" uri="http://java.sun.com/portlet" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="absli.uid.helper.model.Absli" %>
<%@ page import="absli.uid.helper.service.AbsliLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@include file="init.jsp"%>

<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
<%
    long id = ParamUtil.getLong(request, "id");
%>
<portlet:resourceURL var= "uidObjectArrayURL" id="uidObjectArray"/>
<portlet:actionURL name="addUid" var="addUidURL" />
<portlet:resourceURL var="editUrl" id="edit" />
<portlet:resourceURL var="deleteUrl" id="delete" />
<portlet:resourceURL var="productUrl" id="product" />
<aui:form action="<%= addUidURL%>" name="<portlet:namespace /> fm" id="myform">
    <aui:fieldset>
        <aui:select name="product" id="product" class="js-states form-control">
        </aui:select>
        <aui:input name="uid" type="text" id="uid" value=""/>
        <aui:input name="agentCode" type="text" id="agentCode" value=""/>
        <aui:input name="sourceName" type="text" id="sourceName" value=""/>
        <aui:input name="id" type="hidden" id="aId" />
        <aui:input name="id2" type="hidden" id="hId" value="<%= id %>" />
        <aui:fieldset label="discount">
            <aui:input name="discount" label="Yes" type="radio" value="true" id="discount1" checked="false"/>
            <aui:input name="discount" label="No" type="radio" value="false" id="discount2" checked="false"/>
        </aui:fieldset>
        <aui:select name="createdBy">
            <option value="uid-admin" selected="selected">uid-admin</option>
        </aui:select>
    </aui:fieldset>
    <aui:button-row>
        <aui:button type="submit" />
        <aui:button type="reset" id="cancel" value="cancel"/>
    </aui:button-row>
</aui:form>
<table id="uidTable" class="display">
    <thead>
    <tr>
        <th>Product Name</th>
        <th>UID</th>
        <th>Agent Code</th>
        <th>Source Name</th>
        <th>Discount</th>
        <th>Created by</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
</table>
<aui:script>
getProduct()
$('#uidTable').dataTable({
    "ajax": "<%=uidObjectArrayURL%>",
    "columns": [
    { "data": "productName" },
    { "data": "uId" },
    { "data": "agentCode" },
    { "data": "sourceName" },
    { "data": "discount" },
    {"data": "createdBy"}
    ],
        "columnDefs": [
            {
            "targets": 6,
            className: 'dt-body-center',
            "render": function(data, type, row, meta) {
                return '<button class="btn btn-sm btn-warning" name="edtBtn" id="' + row.uId+ '" onclick="editUser(this)">Edit</button>';
                }
            },
            {
                "targets": 7,
                className: 'dt-body-center',
                "render": function(data, type, row, meta) {
                    return '<button class="btn btn-sm btn-danger" name="delBtn" id="' + row.uId+ '" onclick="deleteUser(this)">Delete</button>';
                }
            }
        ]
});
var table = $('#uidTable').DataTable();
$('#<portlet:namespace />uid').on('keyup', function(){
    console.log(this.value);
    table
    .column(1)
    .search(this.value)
    .draw();
});
    function editUser(obj) {
        var id = $(obj).attr('id');
        $.ajax({
            type: "post",
            url: "<%=editUrl%>",
            data: {
            "<portlet:namespace />uid": id,
            flag: "delete",
            },
            success: function(data) {
                var res = $.parseJSON(data);

                $('#<portlet:namespace />product option:contains("' + res.data[0].productName + '")').attr("selected", "selected");

                $('#<portlet:namespace />uid').val(res.data[0].uId);
                $('#<portlet:namespace />agentCode').val(res.data[0].agentCode);
                $('#<portlet:namespace />sourceName').val(res.data[0].sourceName);
                $('#<portlet:namespace />aId').val(res.data[0].id);
                if(res.data[0].discount == true) {
                    $('#<portlet:namespace/>discount1').attr('checked', 'checked');
                } else {
                    $('#<portlet:namespace/>discount2').attr('checked', 'checked');
                }
                $('#uidTable').DataTable().ajax.reload();
            },
            error: function(xhr, error) {
                console.log(xhr.status + " " + error);
            }
        });
        }
    function deleteUser(obj) {
        var id = $(obj).attr('id');
        $.ajax({
            type: "post",
            url: "<%=deleteUrl%>",
            data: {
                "<portlet:namespace />uid": id,
        },
        success: function() {
            $('#uidTable').DataTable().ajax.reload();
        },
        error: function(xhr, error) {
            console.log(xhr.status + " " + error);
        }
        });
    }
    $("#<portlet:namespace />cancel").click(function(){
            console.log("clear");
            $(':input','#<portlet:namespace />myform')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');

    });

function getProduct() {
    $.ajax({
    type: "get",
    url: "<%= productUrl%>",
    success: function(data) {
        var res = JSON.parse(data).data;
        var $select = $("#<portet:namespace/>product");

        $.each(res, function(key, value) {
            console.log(key + " " + value);
                $('<option>').val(value).text(value).appendTo($select);
        });
    },
    error: function(xhr, error) {
        console.log(xhr.status + " " + error);
    }
    })
    }
    $("#<portet:namespace/>product").select2({
        placeholder: "Select a product",
        allowClear: true,
    });
    if($("#<portlet:namespace/>hId").val() > 0) {
        console.log("update");

        $(':input','#<portlet:namespace />myform')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
    }
</aui:script>
