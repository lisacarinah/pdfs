<?php
    include_once('header.php');
?>

 <div id="mainimage">
    <h1>Coronadaten</h1>
</div>
<div id="maincontent">
<h2>Neue Person melden</h2> 
<div id="form">
<form action="database_entry.php" method="post">
        
        <fieldset id="gender" name="gender">
            <label for="Male"><input type="radio" name="gender" value="M">M&auml;nnlich</label>
            <label for="female"><input type="radio" name="gender" value="F">Weiblich</label>
        </fieldset>

        <fieldset>
        <label for="Bundesland">Bundesland</label>        
        <select id="province" name="province">
        <?php

        $mydatabase = new mysqli ('localhost', 'root', '', 'corona');

        if ($mydatabase->connect_error)
        {
            echo "Verbidung fehlgeschlagen".$mydatabase->connect_error;
            exit();
        }
        
        $select = "SELECT province_id, province_name FROM province ORDER BY province_name ASC;";

        $result = $mydatabase->query($select);

        while ($row=$result->fetch_assoc()){
            echo '<option value="'.$row['province_id'].'">'.$row['province_name'].'</option>';
        }

        $mydatabase->close();
        ?>
           
        </select>
        </fieldset>
        <input type="submit" value="Melden">
    </form>
</div>
</div>

<?php
    include_once('footer.php');
?>