<%@ include file="/WEB-INF/jspf/page.jspf" %>
<html>
<c:set var="title" value="Edit topic"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<div class="container">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <form action="" method="post">
        <input type="hidden" name="topic_id" value="${topic.id}">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control"
                   placeholder="Name"
                   id="name" name="name" value="${topic.name}" autocomplete="off">
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea rows="5" cols="33" type="text" class="form-control"
                      placeholder="Description"
                      id="description" name="description" autocomplete="off">${topic.description}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Edit Topic</button>
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