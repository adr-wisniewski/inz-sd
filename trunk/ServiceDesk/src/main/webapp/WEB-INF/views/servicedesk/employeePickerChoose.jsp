<script type="text/javascript">
	opener.document.getElementById('${name}').value = ${employee.id};
	opener.document.getElementById('employeePicker-${name}').value = '${employee.firstname} ${employee.lastname}';
	window.close();
</script>