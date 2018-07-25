<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/libs/foundation/global.jsp"%>

<h4>This is JSP rendering script with OOTB properties used.</h4>
<h4>Use selectors: 'java' and 'kotlin' in order to change rendering script to HTL with Java model or HTL with Kotlin model.</h4>
<div>
   Text Field: ${properties.textfield}
</div>
<div>
   Number Field: ${properties.numberfield}
</div>
<c:if test="${properties.checkbox}">
    <div>
       Calculated value: ${resource.path} ${resource.name}
    </div>
</c:if>



