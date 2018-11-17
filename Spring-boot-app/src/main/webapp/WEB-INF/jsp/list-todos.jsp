<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<table class="table table-striped">
<caption>Vasi todos su</caption>
<thead>
<tr>
<th>Opis</th>
<th>Datum</th>
<th>Zavrseno</th>
<th>Azuriranje</th>
<th>Obrisati</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.desc}</td>
<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
<td>${todo.done}</td>
<td><a type="button" class="btn  btn-success" href="/update-todo?id=${todo.id}">Azuriranje</a></td>
<td><a type="button" class="btn  btn-warning" href="/delete-todo?id=${todo.id}">Obrisati</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<div>
<a class="button" href="/add-todo">Dodajte obavezu</a></div>
</div>
<%@ include file="common/footer.jspf" %>
