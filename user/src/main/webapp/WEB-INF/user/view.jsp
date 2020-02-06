<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<div class="container" style="text-align: center;">
	<div class="btn-group">
		<a href="/" class="btn btn-primary">Home</a> <a href="/users"
			class="btn btn-primary">All Users</a>
	</div>
</div>
<div style="clear: both"></div>
<div class="container" style="margin-top: 15px;">

	<div class="row">
		<c:forEach items="${users}" var="user">

			<div class="col-xs-12 col-sm-4 col-md-4">
				<div class="well well-sm">
					<div class="row">
						<div class="col-sm-6 col-md-4">
							<img src="/photo.png" alt="" class="img-rounded img-responsive" />
						</div>
						<div class="col-sm-6 col-md-8">
							<h4>${user.name}</h4>
							<p>
								<i class="glyphicon glyphicon-envelope"></i> ${user.email}
								<br /> 
								<i class="glyphicon glyphicon-phone"></i>${user.phoneNumber}
								<br/>
								<i class="glyphicon fa fa-venus-double"></i>${user.gender}
								</p>

						</div>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
</div>
<style>
body {
	padding-top: 30px;
}

.glyphicon {
	margin-bottom: 10px;
	margin-right: 10px;
}

small {
	display: block;
	line-height: 1.428571429;
	color: #999;
}
</style>