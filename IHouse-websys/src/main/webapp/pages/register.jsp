<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我爱我家</title>
</head>
<body>
	<p>注册</p>
	<form action="saveRegisterInfo.json" enctype="multipart/form-data" method="post">
		<label for="name">user name: </label>
		<input id="name" type="text" name="name"/>
		
		<label for="mobile">mobile number: </label>
		<input id="mobile" type="text" name="mobile"/>
		
		<label for="image">my image: </label>
		<input id="image" type="file" name="image" />
		
		<input id="reset" type="reset" />
		<input type="submit" type="submit" />
	</form>
</body>
</html>