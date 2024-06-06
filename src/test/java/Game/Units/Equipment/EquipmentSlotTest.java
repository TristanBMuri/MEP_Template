package Game.Units.Equipment;

import Game.Equipment.EquipmentHelpers.ArmorType;
import Game.Equipment.EquipmentHelpers.WeaponType;
import Game.Units.UnitHelpers.Equipment.EquipmentSlots;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EquipmentSlotsTest {

    @Test
    void getDefaultEquipmentSlots() {
        EquipmentSlots equipmentSlots = EquipmentSlots.getDefaultEquipmentSlots();
        assertEquals(1, equipmentSlots.getHelmetCapacity());
        assertEquals(1, equipmentSlots.getArmorCapacity());
        assertEquals(1, equipmentSlots.getWeaponCapacity());
        assertEquals(2, equipmentSlots.getGloveCapacity());
        assertEquals(2, equipmentSlots.getBootCapacity());
        assertEquals(2, equipmentSlots.getRingCapacity());
        assertEquals(2, equipmentSlots.getAmuletCapacity());
        assertTrue(equipmentSlots.isWeaponProficient(WeaponType.SWORD));
        assertTrue(equipmentSlots.isArmorProficient(ArmorType.LIGHT));
    }

    @Test
    void setAndGetCapacity() {
        EquipmentSlots equipmentSlots = new EquipmentSlots(1, 1, 1, 1, 1, 1, 1, new WeaponType[]{}, new ArmorType[]{}, 1);
        equipmentSlots.setHelmetCapacity(2);
        assertEquals(2, equipmentSlots.getHelmetCapacity());
    }

    @Test
    void checkWeaponProficiency() {
        EquipmentSlots equipmentSlots = new EquipmentSlots(1, 1, 1, 1, 1, 1, 1, new WeaponType[]{WeaponType.SWORD}, new ArmorType[]{}, 1);
        assertTrue(equipmentSlots.isWeaponProficient(WeaponType.SWORD));
        assertFalse(equipmentSlots.isWeaponProficient(WeaponType.AXE));
    }

    @Test
    void checkArmorProficiency() {
        EquipmentSlots equipmentSlots = new EquipmentSlots(1, 1, 1, 1, 1, 1, 1, new WeaponType[]{}, new ArmorType[]{ArmorType.HEAVY}, 1);
        assertTrue(equipmentSlots.isArmorProficient(ArmorType.HEAVY));
        assertFalse(equipmentSlots.isArmorProficient(ArmorType.LIGHT));
    }
}