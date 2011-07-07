<%@ page import="googlecharttest.AlexNum" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'alexNum.label', default: 'AlexNum')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-alexNum" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-alexNum" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list alexNum">

        <g:if test="${alexNumInstance?.age}">
            <li class="fieldcontain">
                <span id="age-label" class="property-label"><g:message code="alexNum.age.label" default="Age"/></span>

                <span class="property-value" aria-labelledby="age-label"><g:fieldValue bean="${alexNumInstance}"
                                                                                       field="age"/></span>

            </li>
        </g:if>

        <g:if test="${alexNumInstance?.nom}">
            <li class="fieldcontain">
                <span id="nom-label" class="property-label"><g:message code="alexNum.nom.label" default="Nom"/></span>

                <span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${alexNumInstance}"
                                                                                       field="nom"/></span>

            </li>
        </g:if>

        <g:if test="${alexNumInstance?.prenom}">
            <li class="fieldcontain">
                <span id="prenom-label" class="property-label"><g:message code="alexNum.prenom.label"
                                                                          default="Prenom"/></span>

                <span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${alexNumInstance}"
                                                                                          field="prenom"/></span>

            </li>
        </g:if>

    </ol>
    <g:form>
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${alexNumInstance?.id}"/>
            <g:link class="edit" action="edit" id="${alexNumInstance?.id}"><g:message code="default.button.edit.label"
                                                                                      default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
