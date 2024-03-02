<%@ include file="/WEB-INF/jspf/page.jspf" %>
<html>
<c:set var="title" value="Post"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<div class="container">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <div class="align-content-center">
        <li class="list-group-item">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1"><i class="bi bi-book"> ${post.title}</i></h5>
<%--                <small>Votes: ${post.votes}</small>--%>
            </div>
            <p style="overflow: auto">
                ${post.content}
            </p>
            <p class="mb-1 w-100 justify-content-between d-flex">
                <i class="bi bi-file-earmark-person"> ${post.createdBy}</i>&nbsp;
                <i class="bi bi-calendar-date"> ${post.createdAt}</i>
            </p>
        </li>
    </div>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>