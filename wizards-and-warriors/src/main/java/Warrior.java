class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {
    private static final int VULNERABLE_ATTACK=10;
    private static final int REGULAR_ATTACK=6;
    private static final boolean IS_VULNERABLE = false;

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    boolean isVulnerable() {
        return IS_VULNERABLE;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? VULNERABLE_ATTACK : REGULAR_ATTACK;
    }
}

class Wizard extends Fighter {
    private static final int SPELL_ATTACK=12;
    private static final int REGULAR_ATTACK=3;
    private boolean isSpellReady = false;

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    @Override
    boolean isVulnerable() {
        return isSpellReady ? false : true;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return isSpellReady ? SPELL_ATTACK : REGULAR_ATTACK;
    }

    public void prepareSpell() {
        isSpellReady = true;
    }

}
