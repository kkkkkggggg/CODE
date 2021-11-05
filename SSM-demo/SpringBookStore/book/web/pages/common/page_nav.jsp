<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/25
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
    <%--大于首页，才显示--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>

    <%--页码输出的开始--%>

    <c:choose>
        <%--情况一：如果总页码小于等于5的情况，页码范围是：1-总页码--%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>

        <%--情况二：总页码大于5的情况，假设一共十页--%>
        <c:when test="${requestScope.page.pageTotal > 5}">

            <c:choose>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>

                <c:when test="${requestScope.page.pageNo > 3 && requestScope.page.pageNo < requestScope.page.pageTotal - 2}">
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"/>
                </c:when>

                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>
            </c:choose>

        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            【${i}】
        </c:if>

        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <%--页码输出的开始--%>

    <%--如果已经是最后一页，则不显示下一页，末页--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页

    <input id="searchPageBtn" type="button" value="确定">

    <script type="text/javascript">
        //跳到指定的页码
        $("#searchPageBtn").click(function () {
            let pageNo = $("#pn_input").val();
            //JavaScript语言中提供了一个location地址栏对象
            //它有一个属性叫href，它可以获取地址栏中的地址
            //href属性可读可写
            location.href = "${pageScope.basePath}manager/bookServlet?action=getPage&pageNo=" + pageNo;
        });
    </script>

</div>
