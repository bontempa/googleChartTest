
<%@ page import="googlecharttest.AlexNum" %>
<% int j=0  %>

<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'alexNum.label', default: 'AlexNum')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>


</head>

<body>
<a href="#list-alexNum" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-alexNum" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="age" title="${message(code: 'alexNum.age.label', default: 'Age')}"/>

            <g:sortableColumn property="nom" title="${message(code: 'alexNum.nom.label', default: 'Nom')}"/>

            <g:sortableColumn property="prenom" title="${message(code: 'alexNum.prenom.label', default: 'Prenom')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${alexNumInstanceList}" status="i" var="alexNumInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${alexNumInstance.id}">${fieldValue(bean: alexNumInstance, field: "age")}</g:link></td>

                <td>${fieldValue(bean: alexNumInstance, field: "nom")}</td>

                <td>${fieldValue(bean: alexNumInstance, field: "prenom")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${alexNumInstanceTotal}"/>
    </div>

    <gui:dataTable
    id="dt_2"
    draggableColumns="true"
    columnDefs="[
        [key:'id', sortable:true, resizeable: true, label:'ID'],
        [key:'prenom', sortable:true, resizeable: true, label:'prenom'],
        [key:'nom', sortable:true, resizeable: true, label:'nom'],
        [key:'age', type:'number', sortable:true, resizeable: true, label: 'age'],
    ]"
    paginatorConfig="[
        template:'{PreviousPageLink} {PageLinks} {NextPageLink} {CurrentPageReport}',
        pageReportTemplate:'{totalRecords} total records'
    ]"
    controller="AlexNum" action="dataTableDataAsJSON"
    params="[maxAge:52]"
    resultsList="myResults"
    rowExpansion="true"
    rowsPerPage="3" />


    <%
   def myDailyActivitiesColumns = [['string', 'prenom'], ['number', 'age']]
    %>


<gvisualization:pieCoreChart elementId="piechart" title="My Daily Activities" width="${450}" height="${300}"
 columns="${myDailyActivitiesColumns}" data="${myDailyActivitiesData}" />
<div id="piechart"></div>

</div>


</body>
</html>
