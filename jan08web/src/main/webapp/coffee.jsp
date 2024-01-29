<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>커피 메뉴 고르기</title>
    <link href="./css/index.css" rel="stylesheet"/>
    <link href="./css/menu.css" rel="stylesheet"/>
    <script type="text/javascript" src="./js/menu.js"></script>
    <!-- Include libraries (jQuery, Bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style type="text/css">
    </style>
    <script type="text/javascript">
        $(document).ready(function(){
            // 수정: 해당 부분은 ${person.gender}를 사용하지 않으므로 삭제
        	 let coffee = $('input:radio[name=drink]:checked').val();
        });
    </script>
</head>
<body>
    <div class="container1">
        <header>
            <%@ include file="menu.jsp" %>
        </header>
        <div class="main">
            <div class="mainStyle">
                <article>
                    <div class="main">
                        <div class="mainStyle">
                            <article>
                                <div class="coffee-form">
                                    <div class="mx-5 p-5 bg-warning rounded">
                                        <h1>음료 메뉴 고르기</h1>
                                         <form action="./coffee" method="post" name="coffee">
                                            <div class="input-group mb-2">
                                                <input type='radio' name='drink' value='Hot Americano' checked><label> Hot Americano</label><br> 
                                                <input type='radio' name='drink'' value='Ice Americano'><label> Ice Americano</label><br>
                                                <input type='radio' name='drink'' value='Honey citron tea'><label> Honey citron tea</label><br>
                                                <input type='radio' name='drink'' value='Peppermint tea'><label> Peppermint tea</label><br>                            
                                                <input type='radio' name='drink'' value='cold peach tea' ><label> cold peach tea</label><br>
                                                <input type='radio' name='drink'' value='Hot peach tea' ><label> Hot peach tea</label><br>
                                                <button class="btn btn-success input-group-text" type="submit">음료 선택</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </article>	
                            <div>
                            	<table>
                            		<thead>
                            			<tr>
                            				<th>메뉴명</th>
                            				<th>개수</th>
                            			</tr>
                            		</thead>
                            		<tbody>
                            		${list }
                            		<c:forEach items="${list }" var="coffee">
                            			<tr>
                            				<td>${coffee.menu }</td>
                            				<td>${coffee.count }</td>
                            			</tr>
                            			</c:forEach>
                            		</tbody>
                            	</table>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
        </div>
    </div>
</body>
</html>