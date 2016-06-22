<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
       "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-us">
<head>
	<title>jQuery plugin: Tablesorter 2.0 - Pager plugin</title>
	<link rel="stylesheet" href="css/jq.css" type="text/css" media="print, projection, screen" />
	<link rel="stylesheet" href="../themes/blue/style.css" type="text/css" media="print, projection, screen" />
	<script type="text/javascript" src="../jquery-latest.js"></script>
	<script type="text/javascript" src="js/chili/chili-1.8b.js"></script>
	<script type="text/javascript" src="js/docs.js"></script>
	<script type="text/javascript">
	$(function() {
		$("table")
			.tablesorter({widthFixed: true, widgets: ['zebra']})
			.tablesorterPager({container: $("#pager")});
	});
	</script>
</head>
<body>
<div id="banner">	
	<h1>table<em>sorter</em></h1>
	<h2>Pager plugin</h2>

	<h3>Flexible client-side table sorting</h3>
	
</div>
<div id="main">

<h1>Javascript</h1>
<pre class="javascript">
$(document).ready(function() {
	$("table")
	.tablesorter({widthFixed: true, widgets: ['zebra']})
	.tablesorterPager({container: $("#pager")});
});
</pre>
<h1>Demo</h1>
<table cellspacing="1" class="tablesorter">

	<thead>
		<tr>
			<th>Name</th>
			<th>Major</th>
			<th>Sex</th>
			<th>English</th>
			<th>Japanese</th>

			<th>Calculus</th>
			<th>Geometry</th>

		</tr>
	</thead>
	<tfoot>
		<tr>
			<th>Name</th>

			<th>Major</th>
			<th>Sex</th>
			<th>English</th>
			<th>Japanese</th>
			<th>Calculus</th>
			<th>Geometry</th>

		</tr>
	</tfoot>
	<tbody>
		<tr>
			<td>Student01</td>
			<td>Languages</td>
			<td>male</td>

			<td>80</td>
			<td>70</td>
			<td>75</td>
			<td>80</td>
		</tr>
		<tr>

			<td>Student02</td>

			<td>Mathematics</td>
			<td>male</td>
			<td>90</td>
			<td>88</td>
			<td>100</td>

			<td>90</td>

		</tr>
		<tr>
			<td>Student03</td>
			<td>Languages</td>
			<td>female</td>

			<td>85</td>
			<td>95</td>

			<td>80</td>
			<td>85</td>
		</tr>
		<tr>

			<td>Student04</td>
			<td>Languages</td>
			<td>male</td>

			<td>60</td>
			<td>55</td>
			<td>100</td>

			<td>100</td>
		</tr>

</table>
<div id="pager" class="pager">
	<form>
		<select class="pagesize">
			<option selected="selected"  value="10">10</option>

			<option value="20">20</option>
			<option value="30">30</option>
			<option  value="40">40</option>
		</select>
	</form>
</div>

</div>
<script src="http://www.google-analytics.com/urchin.js" type="text/javascript"></script>

<script type="text/javascript">
_uacct = "UA-2189649-2";
urchinTracker();
</script>
</body>
</html>

