#include <LCD_I2C.h>



#include <SPI.h>
#include <MFRC522.h>
#include <Servo.h>


#define SERVO1 2
#define SERVO2 3



//*****************************************************************************************//
extern void setupRFID();



int select = 0;
Servo s1; // Variável Servo
Servo s2; 
int pos1; // Posição Servo
int pos2;
String price = "";
int vagas = 0;

int estadoAtual[] = {0,0,0,0,0};

LCD_I2C lcd(0x27,16,2);
void setup() {
  
  
  pinMode(5, OUTPUT);
  pinMode(7, OUTPUT);
  lcd.begin();
  lcd.backlight();

  SetupVagas();
  s1.attach(5);
  s1.write(135);
  s2.attach(7);
  s2.write(135);
  delay(400);

  s1.detach();
  s2.detach();
  
  
  setupRFID();
  
  
}

//*****************************************************************************************//


void loop() {
    
    
    
    
    
    
    
    lcd.setCursor(0, 0);

    lcd.print("P. Hora: $" + price); //primeira linha 
    
    LoopVagas();
    lcd.setCursor(0, 1);
    
    String aux = "Vagas livres: " + String(vagas);
    lcd.print(aux); //segunda linha 
  
    vagas = 0;
    
      char reading = Serial.read();
      switch(reading){
      case 'a':
        s1.attach(5);
        for(pos1 = 135; pos1 >= 40; pos1--){
        s1.write(pos1);
        delay(12);
      
      }
      delay(3500);
      
      
      for(pos1 = 40; pos1 <= 135; pos1++){
        s1.write(pos1);
        delay(12);
        }
      s1.detach();
        
        
        break;
        
    case 'b':
     s2.attach(7); 
     
      for(pos2 = 135; pos2 >= 40; pos2--){
        s2.write(pos2);
        delay(12);
      
      }
      delay(3500);
      
      
      for(pos2 = 40; pos2 <= 135; pos2++){
        s2.write(pos2);
        delay(12);
        }
      s2.detach();
        
        
        break;

    case 'p':
      lcd.clear();
      price = Serial.readString();
    }

    
  
  
    loopRFID();
      
  
}