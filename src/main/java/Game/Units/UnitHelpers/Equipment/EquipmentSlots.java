package Game.Units.UnitHelpers.Equipment;

import Game.Equipment.EquipmentHelpers.ArmorType;
import Game.Equipment.EquipmentHelpers.WeaponType;

public class EquipmentSlots {
    private int helmetCapacity;
    private int armorCapacity;
    private int weaponCapacity;
    private int gloveCapacity;
    private int bootCapacity;
    private int ringCapacity;
    private int amuletCapacity;
    private WeaponType[] weaponProficiency;
    private ArmorType[] armorProficiency;
    private int totalCapacity;

    public EquipmentSlots(int helmetCapacity, int armorCapacity, int weaponCapacity, int gloveCapacity, int bootCapacity, int ringCapacity, int amuletCapacity, WeaponType[] weaponProficiency, ArmorType[] armorProficiency, int totalCapacity) {
        this.helmetCapacity = helmetCapacity;
        this.armorCapacity = armorCapacity;
        this.weaponCapacity = weaponCapacity;
        this.gloveCapacity = gloveCapacity;
        this.bootCapacity = bootCapacity;
        this.ringCapacity = ringCapacity;
        this.amuletCapacity = amuletCapacity;
        this.weaponProficiency = weaponProficiency;
        this.armorProficiency = armorProficiency;
        this.totalCapacity = totalCapacity;
    }

    public static EquipmentSlots getDefaultEquipmentSlots() {
        EquipmentSlots equipmentSlots;
        equipmentSlots = new EquipmentSlots(
                1,
                1,
                1,
                2,
                2,
                2,
                2,
                new WeaponType[]{WeaponType.SWORD,
                        WeaponType.AXE,
                        WeaponType.BOW,
                        WeaponType.STAFF,
                        WeaponType.DAGGER,
                        WeaponType.MACE,
                        WeaponType.SPEAR,
                        WeaponType.CROSSBOW,
                        WeaponType.WAND},
                new ArmorType[]{
                        ArmorType.LIGHT,
                        ArmorType.MEDIUM,
                        ArmorType.HEAVY},
                1);
        return equipmentSlots;
    }

    public int getHelmetCapacity() {
        return helmetCapacity;
    }

    public int getArmorCapacity() {
        return armorCapacity;
    }

    public int getWeaponCapacity() {
        return weaponCapacity;
    }

    public int getGloveCapacity() {
        return gloveCapacity;
    }

    public int getBootCapacity() {
        return bootCapacity;
    }

    public int getRingCapacity() {
        return ringCapacity;
    }

    public int getAmuletCapacity() {
        return amuletCapacity;
    }

    public WeaponType[] getWeaponProficiency() {
        return weaponProficiency;
    }

    public boolean isWeaponProficient(WeaponType weaponType) {
        for (WeaponType type : weaponProficiency) {
            if (type.equals(weaponType)) {
                return true;
            }
        }
        return false;
    }

    public ArmorType[] getArmorProficiency() {
        return armorProficiency;
    }

    public boolean isArmorProficient(ArmorType armorType) {
        for (ArmorType type : armorProficiency) {
            if (type.equals(armorType)) {
                return true;
            }
        }
        return false;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public void setHelmetCapacity(int helmetCapacity) {
        this.helmetCapacity = helmetCapacity;
    }

    public void setArmorCapacity(int armorCapacity) {
        this.armorCapacity = armorCapacity;
    }

    public void setWeaponCapacity(int weaponCapacity) {
        this.weaponCapacity = weaponCapacity;
    }

    public void setGloveCapacity(int gloveCapacity) {
        this.gloveCapacity = gloveCapacity;
    }

    public void setBootCapacity(int bootCapacity) {
        this.bootCapacity = bootCapacity;
    }

    public void setRingCapacity(int ringCapacity) {
        this.ringCapacity = ringCapacity;
    }

    public void setAmuletCapacity(int amuletCapacity) {
        this.amuletCapacity = amuletCapacity;
    }

    public void setWeaponProficiency(WeaponType[] weaponProficiency) {
        this.weaponProficiency = weaponProficiency;
    }

    public void setArmorProficiency(ArmorType[] armorProficiency) {
        this.armorProficiency = armorProficiency;
    }


}
