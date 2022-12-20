

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>

<body onload="loadTotalMoney()">
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="shopping-cart">
		<div class="px-4 px-lg-0">

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<c:if test="${error!=null }">
											<div class="alert alert-danger" role="alert">${error}</div>
										</c:if>
										<c:if test="${mess!=null }">
											<div class="alert alert-success" role="alert">${mess}</div>
										</c:if>
										<tr style="text-align: center">
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Mã đơn</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Sản phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Ngày đặt</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Trạng thái</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${ordList}" var="o">
											<c:forEach items="${oItemList}" var="oi">
													<c:if test="${o.id == oi.ordID}">
														<c:forEach items="${listProd}" var="p">
																<c:if test="${oi.prodID == p.id}">
																	<tr style="text-align: center">
																		<td><a href="<c:url value='/detailOrder?id=${oi.ordID}'/>">${oi.ordID}</a></td>
																		<td>${p.name}</td>
																		<td>${oi.createAt}</td>
																		<td class="align-middle"><c:choose>
																				<c:when test="${o.status==1 }">
																					<strong style="color: green;">Đã xác nhận</strong>
																				</c:when>
																				<c:when test="${o.status==0 }">
																					<strong style="color: red;">Chưa xác nhận</strong>
																				</c:when>
																			</c:choose></td>
																	</tr>
																</c:if>
														</c:forEach>
													</c:if>
											</c:forEach>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</body>
</html>
