<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="<c:url value="/css/welcome.css"/>"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
    <script src="<c:url value="/js/welcome.js"/>" type="text/javascript"></script>
</head>
<body class="back-picture">
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    %>

    <c:if test="${username != null}">
    <div id="username-container"><h1>${username}</h1></div>
    <form action="/logout" method="post" class="welcome-shift">
        <input type="submit" value="Logout"/>
    </form>
    </c:if>

    <div class="sample-class">
        <div class="modal-w">
            <div class="title"><h1>Synthetic Generator</h1></div>
            <div class="modal-w-row">

                <div class="table">
                    <div class="table-thead">
                        <ul class="table-tr">
                            <li class="table-th">Filed Name</li>
                            <li class="table-th">Type</li>
                            <li class="table-th">Precision</li>
                            <li class="table-th">Primary Key</li>
                            <li class="table-th"><input id="del" type="button" value="Del"/></li>
                        </ul>
                    </div>
                    <div class="table-tbody">
                        <ul class="table-tr tr-body" id='first-row-table-body'>
                            <li class="table-td"><input type="text" class="field-name"/></li>
                            <li class="table-td">
                                <select class="type">//loop set values of types
                                    <option selected>VARCHAR</option>
                                    <option>CHAR</option>
                                    <option>INT</option>
                                    <option>UNSIGNED INT</option>
                                    <option>DECIMAL</option>
                                    <option>DATE</option>
                                    <option>BOOLEAN</option>
                                </select>
                            </li>
                            <li class="table-td"><input type="text" class="precision"/></li>
                            <li class="table-td">
                                <input type="radio" class="pk" name="pk" style="visibility:hidden"/>
                            </li>
                            <li class="table-td">
                                <input type="checkbox" class="del" name="del"/>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="welcome-shift"><input type="submit" value="Add row" id="addRow"/></div>

            </div>
            <div class="modal-w-row">
                <div id="finish-attrs">
                    <div name="insert-script" id="insert-script">
                        <input id="insert" type="radio" name="script" checked/>
                        <label for="insert">Insert script</label>
                    </div>
                    <div name="update-script" id="update-script">
                        <input id="update" type="radio" name="script"/>
                        <label for="update">Update script</label>
                    </div>
                    <div name="add-create-script">
                        <input type="checkbox" name="addCS" value="addCS" id="add-create-script"/>
                        <label for="add-create-script">Add creating script</label>
                    </div>
                    <div name="addId">
                        <input type="checkbox" name="addId" value="addId" id="addId"/>
                        <label for="addId">Add id autoincrement</label>
                    </div>
                </div>
                <!--<form action="" method="get" id="generate">-->
                <button type="submit" value="Generate" id="generate">Generate</button>
                <!--</form>-->
            </div>
        </div>
    </div>
</body>
</html>
