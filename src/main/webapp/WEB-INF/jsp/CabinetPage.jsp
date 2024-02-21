<%@ include file="/WEB-INF/jspf/page.jspf" %>
<html>
<c:set var="title" value="Cabinet"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<body>
<div class="container">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <div>
        <c:if test="${not empty userPosts}">
            <ul class="list-group list-group-flush">
                <c:forEach var="post" items="${userPosts}">
                    <div class="row d-flex justify-content-center mb-3">
                        <div class="col-md-8">
                            <li class="list-group-item">
                                <div class="d-flex w-100 justify-content-between">
                                    <h5 class="mb-1"><i class="bi bi-book"><a style="text-decoration: none;"
                                                                              href="/jsp/post?post_id=${post.id}"> ${post.title}</a></i>
                                    </h5>
                                    <h5 class="mb-1">[${post.topic.name}]
                                    </h5>
                                        <%--                                    <small>Votes: ${post.votes}</small>--%>
                                </div>
                                <div class="w-100 text-truncate mt-1 mb-1">
                                        ${post.content}
                                </div>
                                <p class="mb-1 w-100 justify-content-between d-flex">
                                    <i class="bi bi-file-earmark-person"> ${post.createdBy}</i>&nbsp;
                                    <i class="bi bi-calendar-date"> ${post.createdAt}</i>
                                </p>
                            </li>
                        </div>
                        <c:if test="${user.role eq 'ADMIN'}">
                            <div class="col-xs-2 mr-1">
                                <form class="" action="/jsp/editPost" method="get">
                                    <input type="hidden" name="post_id" value="${post.id}">
                                    <button type="submit" class="btn btn-outline-primary"><fmt:message
                                            key="home_jsp.button.edit"/>
                                    </button>
                                </form>
                            </div>
                            <div class="col-xs-2">
                                <form class="" action="/jsp/deletePost" method="post">
                                    <input type="hidden" name="post_id" value="${post.id}">
                                    <button type="submit" class="btn btn-outline-danger"><fmt:message
                                            key="home_jsp.button.delete"/>
                                    </button>
                                </form>
                            </div>
                        </c:if>
                    </div>
                </c:forEach>
            </ul>
        </c:if>
    </div>

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
</html>
