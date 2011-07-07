<%@ page import="googlecharttest.AlexNum" %>



<div class="fieldcontain ${hasErrors(bean: alexNumInstance, field: 'age', 'error')} required">
    <label for="age">
        <g:message code="alexNum.age.label" default="Age"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field type="number" name="age" required="" value="${fieldValue(bean: alexNumInstance, field: 'age')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: alexNumInstance, field: 'nom', 'error')} ">
    <label for="nom">
        <g:message code="alexNum.nom.label" default="Nom"/>

    </label>
    <g:textField name="nom" value="${alexNumInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: alexNumInstance, field: 'prenom', 'error')} ">
    <label for="prenom">
        <g:message code="alexNum.prenom.label" default="Prenom"/>

    </label>
    <g:textField name="prenom" value="${alexNumInstance?.prenom}"/>
</div>

