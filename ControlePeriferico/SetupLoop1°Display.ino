#include <Arduino_GFX_Library.h>
#include "Arduino_DataBus.h"
#include "Arduino_GFX.h"


#define GFX_BL1 

Arduino_DataBus *bus1 = new Arduino_SWSPI(5 /* DC */, 2 /* CS */, 19 /* SCK */, 18 /* SDA */, -1 /* MISO */);
Arduino_GFX *gfx1 = new Arduino_SSD1283A(bus1, 4 /* RST */, 2 /* rotation */);

extern const uint16_t epd_bitmap_LogoOriginal[];
extern const uint16_t epd_bitmap_LogoMelhorada[];

void setup1()
{
  gfx1->begin();
}

void loop1()
{
  gfx1->draw16bitRGBBitmap(0,0, epd_bitmap_LogoOriginal, 130, 130);
  delay(1500);
  gfx1->draw16bitRGBBitmap(0,0, epd_bitmap_LogoMelhorada, 130, 130);
  delay(100);
}