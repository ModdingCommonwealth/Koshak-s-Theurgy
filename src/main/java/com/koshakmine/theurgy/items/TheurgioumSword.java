package com.koshakmine.theurgy.items;
import com.koshakmine.theurgy.Main;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class TheurgioumSword extends SwordItem {


    public TheurgioumSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("tooltip.theurgy.thswdinf"));
        } else {
            tooltip.add(new TranslatableText("tooltip.theurgy.holdshift"));
        }
        super.appendTooltip(stack, world, tooltip, context);
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