<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>刷卡</title>
    <!-- Bootstrap core CSS -->
    <link href="/static/asserts/css/bootstrap.min.css"rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/static/asserts/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
    <form class="form-signin" action="/user/login" method="post">
        <img class="mb-4" src="/static/asserts/img/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label class="sr-only">Username</label>
        <input type="text" class="form-control" name="username" placeholder="Username" required="" autofocus="">
        <label class="sr-only">Password</label>
        <input type="password" class="form-control" name="password" placeholder="Password" required="">
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
        <a class="btn btn-sm">中文</a>
        <a class="btn btn-sm">English</a>
    </form>
</body>

</html>