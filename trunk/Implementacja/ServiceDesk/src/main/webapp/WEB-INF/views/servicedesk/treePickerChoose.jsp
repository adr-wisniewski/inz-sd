<script type="text/javascript">
        if(opener) {
            opener.document.getElementById('${target}').value ='${item.id}';
            opener.document.getElementById('treePicker-${target}').value = '${item.name}';
        }
	window.close();
</script>