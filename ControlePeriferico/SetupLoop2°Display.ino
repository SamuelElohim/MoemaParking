#include <Arduino_GFX_Library.h>
#include "Arduino_DataBus.h"
#include "Arduino_GFX.h"

#define GFX_BL2

extern const uint16_t epd_bitmap_Texto[];

Arduino_DataBus *bus2 = new Arduino_SWSPI(27 /* DC */, 13 /* CS */, 32 /* SCK */, 25 /* SDA */, -1 /* MISO */);
Arduino_GFX *gfx2 = new Arduino_SSD1283A(bus2, 12 /* RST */, 2 /* rotation */);

void setup2()
{
  gfx2->begin();
}

void loop2()
{
  gfx2->draw16bitRGBBitmap(0,0, epd_bitmap_Texto, 130, 130);
  
}