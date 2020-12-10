<?php
    include_once('header.php');
?>

 <div id="mainimage">
    <h1>Coronadaten</h1>
</div>
<div id="maincontent">
    <?php 
        $mydatabase = new mysqli ('localhost', 'root', '', 'corona');

        if ($mydatabase->connect_error)
        {
            echo "Verbindung fehlgeschlagen".$mydatabase->connect_error;
            exit();
        }

        $gender = $_POST['gender'];
        $province = $_POST['province'];
        //echo 'Geschlecht: '.$gender.'</br>';
        //echo 'Province: '.$province.'</br>';

        $insert = "INSERT INTO person (gender, province_id) VALUES ('".$gender."','".$province."');";
        //echo $insert;
        
        if($mydatabase->query($insert))
        {
            echo 'Person wurde hinzugefügt';
        }
        else {
            echo 'Fehler beim Einfügen';
        }

        $mydatabase->close();
    ?>

</div>

<?php
    include_once('footer.php');
?>