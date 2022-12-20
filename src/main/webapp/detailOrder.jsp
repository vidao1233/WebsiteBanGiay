

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
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Đơn Giá</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Màu Sắc</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Số Lượng</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listOrdI}" var="o">
											<c:forEach items="${listProd}" var="p">
												<c:if test="${o.prodID==p.id}">
													<tr>
														<th scope="row">
															<div class="p-2">
																<img src="${p.image}" alt="" width="70"
																	class="img-fluid rounded shadow-sm">

																<div class="ml-3 d-inline-block align-middle">
																	<h5 class="mb-0">
																		<a href="#" class="text-dark d-inline-block">${p.name}</a>
																	</h5>
																	<span class="text-muted font-weight-normal font-italic"></span>
																</div>
															</div>
														</th>
														<td class="align-middle"><strong>${p.price}$</strong></td>
														<td class="align-middle"><strong>${p.color}</strong></td>
														<td class="align-middle"><strong>${o.count}</strong></td>
													</tr>
												</c:if>
											</c:forEach>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row py-5 p-4 bg-white rounded shadow-sm">

						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành
								tiền</div>
							<c:forEach items="${listOrdI}" var="o">
								<c:forEach items="${listProd}" var="p">
									<c:if test="${o.prodID==p.id}">
										<div class="p-4">
											<ul class="list-unstyled mb-4" id="contentTotalMoney">
											
												<li
													class="d-flex justify-content-between py-3 border-bottom"><strong
													class="text-muted">Tổng số lượng</strong><strong>${amount}</strong></li>
												<li
													class="d-flex justify-content-between py-3 border-bottom"><strong
													class="text-muted">Phí vận chuyển</strong><strong>Free
														ship</strong></li>
												<li
													class="d-flex justify-content-between py-3 border-bottom"><strong
													class="text-muted">VAT</strong><strong>10%</strong></li>
												<li
													class="d-flex justify-content-between py-3 border-bottom"><strong
													class="text-muted">Tổng thanh toán</strong>
													<h5 class="font-weight-bold">${o.count*p.price*1.1}$</h5></li>
											</ul>
										</div>
									</c:if>
								</c:forEach>
							</c:forEach>
						</div>
						<div
							class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Đơn hàng</div>
						<c:forEach items="${listOrdI}" var="o">
							<c:forEach items="${listProd}" var="p">
								<c:if test="${o.prodID==p.id}">
									<div class="p-4">
										<ul class="list-unstyled mb-4" id="contentTotalMoney">
											<li class="d-flex justify-content-between py-3 border-bottom"><strong
												class="text-muted">Trạng thái</strong><strong><c:choose>
													<c:when test="${order.status==1}">
														<a style="color: green;">Processed</a>
													</c:when>
													<c:when test="${order.status==0}">
													<a style="color: red;">Processing</a>
													</c:when>
												</c:choose></strong></li>
											<li class="d-flex justify-content-between py-3 border-bottom"><strong
												class="text-muted">ĐV Vận chuyển :     </strong><strong>${del.name}</strong></li>
											<li class="d-flex justify-content-between py-3 border-bottom"><strong
												class="text-muted">Ngày đặt: </strong><strong>${o.createAt}</strong></li>
											<li class="d-flex justify-content-between py-3 border-bottom"><strong
												class="text-muted">Nơi giao: </strong><strong>${order.detail}</strong></li>
											<li class="d-flex justify-content-between py-3 border-bottom"><strong
												class="text-muted"></strong><strong>${order.ward} ${order.district} ${order.province}</strong></li>
										</ul>
									</div>
								</c:if>
							</c:forEach>
						</c:forEach>
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