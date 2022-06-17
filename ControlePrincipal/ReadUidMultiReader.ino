
#include <SPI.h>
#include <MFRC522.h>

#define RST_PIN         47         // Configurable, see typical pin layout above
#define SS_1_PIN        49         // Configurable, take a unused pin, only HIGH/LOW required, must be different to SS 2
#define SS_2_PIN        46         // Configurable, take a unused pin, only HIGH/LOW required, must be different to SS 1

#define NR_OF_READERS   2

byte ssPins[] = {SS_1_PIN, SS_2_PIN};

MFRC522 mfrc522[NR_OF_READERS];   // Create MFRC522 instance.

byte wait = 1;

/**
 * Initialize.
 */
 
void setupRFID() {

  Serial.begin(115200); // Initialize serial communications with the PC
  Serial.setTimeout(2000);
  while (!Serial);    // Do nothing if no serial port is opened (added for Arduinos based on ATMEGA32U4)

  SPI.begin();        // Init SPI bus

  for (uint8_t reader = 0; reader < NR_OF_READERS; reader++) {
    mfrc522[reader].PCD_Init(ssPins[reader], RST_PIN); // Init each MFRC522 card
    
  }
}

/**
 * Main loop.
 */
void loopRFID() {
  
    for (uint8_t reader = 0; reader < NR_OF_READERS; reader++) {
      // Look for new cards

      if (mfrc522[reader].PICC_IsNewCardPresent() && mfrc522[reader].PICC_ReadCardSerial()) {
        
        //Serial.print(reader);
        // Show some details of the PICC (that is: the tag/card)
        
        dump_byte_array(mfrc522[reader].uid.uidByte, mfrc522[reader].uid.size);
        Serial.println();
        

        // Halt PICC
        mfrc522[reader].PICC_HaltA();
        // Stop encryption on PCD
        mfrc522[reader].PCD_StopCrypto1();
      } //if (mfrc522[reader].PICC_IsNewC
    } //for(uint8_t reader
  }


/**
 * Helper routine to dump a byte array as hex values to Serial.
 */
void dump_byte_array(byte *buffer, byte bufferSize) {
  
    for (byte i = 0; i < bufferSize; i++) {
      Serial.print(buffer[i] < 0x10 ? "0" : "");
      Serial.print(buffer[i], HEX);
    }
    
  
  
}
