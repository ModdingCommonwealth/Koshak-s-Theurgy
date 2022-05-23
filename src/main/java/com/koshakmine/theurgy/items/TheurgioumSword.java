package com.koshakmine.theurgy.items;
import com.koshakmine.theurgy.Main;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;

import java.util.Random;

public class TheurgioumSword extends SwordItem {


    public TheurgioumSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(target.isAlive()) {

        } else {
            Random rnd = new Random();
            int rand = 0;
            while (true){
                rand = rnd.nextInt(11);
                if(rand !=0) break;
            }
            if(rand == 1) {
                ItemStack item = new ItemStack(Main.BloodyEssence);
                target.dropStack(item);
            }

        }

        return super.postHit(stack, target, attacker);
    }
}