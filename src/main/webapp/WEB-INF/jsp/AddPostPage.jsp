<%@ include file="/WEB-INF/jspf/page.jspf" %>
<html>
<c:set var="title" value="Add book"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<div class="container">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <form action="" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control"
                   placeholder="Title"
                   id="title" name="title" autocomplete="off">
        </div>
        <div class="form-group">
            <label for="content">Content:</label>
            <input type="text" class="form-control"
                   placeholder="Content"
                   id="content" name="content" autocomplete="off">
        </div>
        <c:if test="${not empty topicList}">
            <div class="form-group">
                <label>Topic:</label>
                <label>
                    <select class="custom-select" name="topic">
                        <c:forEach var="topic" items="${topicList}">
                            <option value="${topic.name}">
                                    ${topic.name}
                            </option>
                        </c:forEach>
                    </select>
                </label>
            </div>
        </c:if>
        <button type="submit" class="btn btn-primary">Add Post</button>
    </form>


    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
        integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
        crossorigin="anonymous"></script>
</body>
<!-- this should go after your </body> -->
<link rel="stylesheet" type="text/css" href="/css/jquery.datetimepicker.css"/>
<script src="/js/jquery.js"></script>
<script src="/js/jquery.datetimepicker.full.min.js"></script>
<script>
    jQuery.noConflict();
    jQuery('.datepicker').datetimepicker({
        timepicker: false,
        format: 'd/m/Y'
    });
</script>
</html>