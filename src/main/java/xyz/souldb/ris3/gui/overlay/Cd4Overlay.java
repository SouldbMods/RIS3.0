
package xyz.souldb.ris3.gui.overlay;

import xyz.souldb.ris3.procedures.Cd4cProcedure;
import xyz.souldb.ris3.Ris3ModElements;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import com.google.common.collect.ImmutableMap;

@Ris3ModElements.ModElement.Tag
public class Cd4Overlay extends Ris3ModElements.ModElement {
	public Cd4Overlay(Ris3ModElements instance) {
		super(instance, 224);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (Cd4cProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "7", posX + -3, posY + -8, -26368);
			}
		}
	}
}
