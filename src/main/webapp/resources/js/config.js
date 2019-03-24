/**
 * To config the webDB 
 */

function configDB() {
	try
    {
      if (!window.openDatabase) {
            alert('Not Supported -> Please try with a WebKit Browser');
      } 
      else {
         var shortName = 'stockieWebDB';
         var version = '1.0';
         var displayName = 'User Settings Database';
         var maxSize = 3072*1024; //  = 3MB            in bytes 65536
         db = openDatabase(shortName, version, displayName, maxSize);
         
         db.transaction(function(tx){
        	 tx.executeSql('CREATE TABLE IF NOT EXISTS PRODUCT(prodId, prodName, quantity, price, quantitySold, totalQuantity)');
         });
         
         return db;
      }
    } 
    catch(e) 
    {
      if (e == 2) {

          alert("Invalid database version.");
      } else {
          alert("Unknown error "+e+".");
      }return;
    }
}
