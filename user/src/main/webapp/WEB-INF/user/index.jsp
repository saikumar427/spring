<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container">

	<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
			<h4 class="card-title mt-3 text-center">Create Account</h4>

			<form action="/user" method="post">
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-user"></i>
						</span>
					</div>
					<input name="name" class="form-control" placeholder="Full name"
						type="text">
				</div>
				<!-- form-group// -->
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-envelope"></i>
						</span>
					</div>
					<input name="email" class="form-control"
						placeholder="Email address" type="email">
				</div>
				<!-- form-group// -->
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-phone"></i>
						</span>
					</div>
					<input name="phoneNumber" class="form-control"
						placeholder="Phone number" type="text">
				</div>
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i style="font-size: 26px;" class="fa fa-venus"></i>
						</span>
					</div>
						<label class="radio-inline form-control" for="Gender-0"> 
							<input type="radio" name="gender" id="Gender-0" value="male" checked="checked"> Male
						</label> 
						<label class="radio-inline form-control" for="Gender-1"> 
							<input type="radio" name="gender" id="Gender-1" value="female"> Female
						</label>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						Create Account</button>
				</div>
				<!-- form-group// -->
			</form>
		</article>
	</div>
	<!-- card.// -->

</div>
<!--container end.//-->

<br>
<br>
<style>
.divider-text {
	position: relative;
	text-align: center;
	margin-top: 15px;
	margin-bottom: 15px;
}

.divider-text span {
	padding: 7px;
	font-size: 12px;
	position: relative;
	z-index: 2;
}

.divider-text:after {
	content: "";
	position: absolute;
	width: 100%;
	border-bottom: 1px solid #ddd;
	top: 55%;
	left: 0;
	z-index: 1;
}
</style>