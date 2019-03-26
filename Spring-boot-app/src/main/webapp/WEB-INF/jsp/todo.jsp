<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">
<<<<<<< HEAD
		Add to-do for ${username}

		<form:form method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text"
					class="form-control" required="required"/>
					<!-- form:errors nam prikazuje error message ako do nje dodje, error message je kod @Size annotacije u Todo klasi  -->
			<form:errors path="desc" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="targetDate">Expected date</form:label>
			<form:input path="targetDate" type="text"
					class="form-control" required="required"/>
					<!-- form:errors nam prikazuje error message ako do nje dodje, error message je kod @Size annotacije u Todo klasi  -->
			<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
			
			<button type="submit" class="btn btn-success">Confirm</button>
=======
		Dodaj Todo za ${name}

		<form:form method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:label path="desc">Opis</form:label>
			<form:input path="desc" type="text"
					class="form-control" required="required"/>
					<!-- form:errors nam prikazuje error message ako do nje dodje, error message je kod @Size annotacije u Todo klasi  -->
			<form:errors path="desc" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="targetDate">Konacni datum</form:label>
			<form:input path="targetDate" type="text"
					class="form-control" required="required"/>
					<!-- form:errors nam prikazuje error message ako do nje dodje, error message je kod @Size annotacije u Todo klasi  -->
			<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
			
			<button type="submit" class="btn btn-success">Potvrdi</button>
>>>>>>> branch 'master' of https://github.com/NemanjaDj/Spring-boot-app.git
		</form:form>
	</div>
<%@ include file="common/footer.jspf" %>