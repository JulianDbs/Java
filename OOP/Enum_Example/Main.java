public class Main {
  public static void main(String[] args) {
    Weapon woodenSword = new Weapon(WeaponType.Sword, WeaponMaterial.Wood);
    System.out.println("woodenSword Type : " + woodenSword.Type);
    System.out.println("woodenSword Damage : " + woodenSword.Damage);
    System.out.println("woodenSword Material : " + woodenSword.Material);
    System.out.println("woodenSword Durability : " + woodenSword.Durability);
  }
}

public enum WeaponMaterial {
  Wood (5),
  Cooper (10),
  Iron (15),
  Steal (20);

  public final int Durability;

  private WeaponMaterial(int Durability) {
    this.Durability = Durability;
  }

  public int GetDurability() {return Durability;}
}

public enum WeaponType {
  Axe (10),
  Sword (9),
  Spear (13),
  Dagger (7);

  public final int Damage;

  private WeaponType(int Damage) {
    this.Damage = Damage;
  }

  public int GetDamage() {return Damage;}
}

public class Weapon {
    public final int Damage;
    public final int Durability;
    public final WeaponType Type;
    public final WeaponMaterial Material;

    public Weapon(WeaponType Type, WeaponMaterial Material) {
      this.Type = Type;
      this.Damage = Type.GetDamage();
      this.Material = Material;
      this.Durability = Material.GetDurability();
    }
}
