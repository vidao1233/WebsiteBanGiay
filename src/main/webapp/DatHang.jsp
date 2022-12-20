<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<title>Order</title>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<hr><br>
	<div class="mb-4">
	<div class="table-responsive">

		<form class="form-signin" action="order" method="post" >
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
							<div class="py-2 text-uppercase">Kích Thước</div>
						</th>
						<th scope="col" class="border-0 bg-light">
							<div class="py-2 text-uppercase">Số Lượng</div>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listCart}" var="o">
						<c:forEach items="${listProduct}" var="p">
							<c:if test="${o.productID == p.id}">
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
									<td hidden class="align-middle"><input name="prodID"
										hidden value="${p.id}"></td>
									<td class="align-middle"><strong>${p.price}$</strong></td>
									<td class="align-middle"><strong>${p.color}</strong></td>
									<td class="align-middle"><strong>${o.size}</strong></td>

									<td class="align-middle"><strong><input name="count"
										hidden value="${o.amount}">${o.amount}</strong></td>
								</tr>
							</c:if>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>
		<div class="card">
        <div class="card-header border-0 bg-light" style="width: 100%">
          <h5 class="mb-0 text-left">
            <strong>THÔNG TIN GIAO HÀNG:</strong>
          </h5>
          </div>
        </div>
				<c:if test="${error!=null }">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:if>
				<c:if test="${mess!=null }">
					<div class="alert alert-success" role="alert">${mess}</div>
				</c:if>
				<input hidden name="uID" value="${sessionScope.acc.id}"> 
				<div class="table" style="width: 40vw; margin-left: 30vw; margin-right: 20vw;">
				
					<div class="form-group">
						<label for="name">Tên người nhận:</label> 
							<input name="name" type="text" id="name"
							class="form-control" placeholder="Name" required="" autofocus="">
					</div>		
				
					<div class="form-group">
						<label for="province">Tỉnh/Thành phố:</label> 
							<input name="province"
							type="text" id="province" class="form-control" placeholder="Tỉnh/Thành phố"
							required="" autofocus=""> 
					</div>
					
					<div class="form-group">
						<label for="district">Quận/Huyện:</label>
							<input name="district" type="text" id="district"
							class="form-control" placeholder="Quận/Huyện" required=""
							autofocus=""> 
					</div>					
					
					<div class="form-group">
						<label for="ward">Phường/Xã:</label> 
							<input name="ward" type="text" id="ward" class="form-control"
							placeholder="Phường/Xã.." required="" autofocus=""> 
					</div>
					
					<div class="form-group">	
						<label for="detail">Số nhà:</label> 
							<input name="detail" type="text" id="detail" class="form-control" placeholder="Detail" required=""
							autofocus=""> 
					</div>
						
					<div class="form-group">
						<label for="phone">Số điện thoại:</label> 
							<input name="phone" type="text" id="phone" class="form-control"
							placeholder="Phone number" required="" autofocus=""> 
					</div>
					
					<div class="form-group">
						<label for="email">Email:</label> 
							<input name="email" type="text" id="email" class="form-control" placeholder="email" required=""
							autofocus=""> 
					</div>
					
					<div class="form-group">
						<label for="delivery">Đơn vị vận chuyển:</label> <select
							class="custom-select custom-select-sm form-control form-control-sm"
							name="delivery" id="delivery">
							<c:forEach items="${dels}" var="del">
							<option value="${del.id}">${del.name}</option>
							</c:forEach>
						</select>
					</div>
						<br>
					<button class="btn btn-success btn-block" type="submit">
						<i class="fas fa-american-sign-language-interpreting"></i>Đặt hàng
					</button>
				</div>

				<br>			
		</form>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script>
            function toggleResetPswd(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle() // display:block or none
                $('#logreg-forms .form-reset').toggle() // display:block or none
            }

            function toggleSignUp(e) {
                e.preventDefault();
                $('#logreg-forms .form-signin').toggle(); // display:block or none
                $('#logreg-forms .form-signup').toggle(); // display:block or none
            }

            $(() => {
                // Login Register Form
                $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                $('#logreg-forms #btn-signup').click(toggleSignUp);
                $('#logreg-forms #cancel_signup').click(toggleSignUp);
            })
            
            window.addEventListener("load",function loadAmountCart(){
                        	 $.ajax({
                                 url: "/WebsiteBanGiay/loadAllAmountCart",
                                 type: "get", //send it through get method
                                 data: {
                                     
                                 },
                                 success: function (responseData) {
                                     document.getElementById("amountCart").innerHTML = responseData;
                                 }
                             });
                        },false);         
        </script>
</body>
</html>