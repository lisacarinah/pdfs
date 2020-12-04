<?php
    include_once('header.php');
?>


<div id="mainimage">
    <h1>Gesundmeldung</h1>
</div>
<div id="maincontent">
    <h2>Person gesund melden</h2>
<section id="form">
    <form action="senddata_delete.php" method="post">
        <label for="reg_date">Datum der Registrierung:</label>
        <input type="date" id="reg_date" name="reg_date">
        <fieldset id="gender" name="gender">
            <label for="Male">M&auml;nnlich</label>
            <input type="radio" name="gender" value="M">
            <label for="female">Weiblich</label>
            <input type="radio" name="gender" value="F">
        </fieldset>
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
        <input type="submit" value="Gesund melden">
    </form>

</section>
</div>

<?php
    include_once('footer.php');
?>