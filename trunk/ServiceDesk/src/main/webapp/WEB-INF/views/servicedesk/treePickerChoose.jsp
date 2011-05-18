<script type="text/javascript">
        if(opener) {
            opener.document.getElementById('${name}').value ='${item.id}';
            opener.document.getElementById('treePicker-${name}').value = '${item.name}';
        }
	window.close();
</script>