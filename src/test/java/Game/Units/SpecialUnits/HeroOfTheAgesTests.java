package Game.Units.SpecialUnits;

import Game.Equipment.EquipmentHelpers.Weapon;
import Game.Equipment.Excalibur;
import Game.Helpers.AttackEvent;
import Game.Units.HeroOfTheAges;
import Game.Units.UnitHelpers.Damage;
import Game.Units.UnitHelpers.DamageTypes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroOfTheAgesTest {
    @Test
    void testHeroOfTheAgesInitialization() {
        HeroOfTheAges hero = new HeroOfTheAges("Test Hero");
        assertEquals("Test Hero", hero.getName());
        assertEquals(100, hero.getHealth());
        assertEquals(100, hero.getMaxHealth());
        assertEquals(100, hero.getBaseAttackDamage());
        assertEquals(10, hero.getLevel());
        assertEquals(0, hero.getExperience());
        assertEquals(0, hero.getGoldUpkeep());
        assertNotNull(hero.getEquipmentSlots());
    }

    @Test
    void testHeroOfTheAgesAttack() {
        HeroOfTheAges hero = new HeroOfTheAges("Test Hero");
        HeroOfTheAges enemy = new HeroOfTheAges("Test Enemy");
        hero.attack(enemy);
        assertTrue(enemy.getHealth() < 100);
    }

    @Test
    void testHeroOfTheAgesTakeDamage() {
        HeroOfTheAges hero = new HeroOfTheAges("Test Hero");
        HeroOfTheAges enemy = new HeroOfTheAges("Test Hero");
        Damage damage = new Damage(DamageTypes.PHYSICAL, 10);
        AttackEvent attack = new AttackEvent(enemy, hero, damage);
        hero.takeDamage(attack);
        assertTrue(hero.getHealth() < 100);
    }

    @Test
    void testHeroOfTheAgesEquipWeapon() {
        HeroOfTheAges hero = new HeroOfTheAges("Test Hero");
        Weapon weapon = new Excalibur();
        hero.equipWeapon(weapon);
        assertEquals(weapon, hero.getEquippedWeapon());
    }

    @Test
    void testHeroOfTheAgesUnequipWeapon() {
        HeroOfTheAges hero = new HeroOfTheAges("Test Hero");
        Weapon weapon = new Excalibur();
        hero.equipWeapon(weapon);
        hero.unequipWeapon();
        assertNull(hero.getEquippedWeapon());
    }
}
