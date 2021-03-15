/*
 * This file is part of Baritone.
 *
 * Baritone is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Baritone is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Baritone.  If not, see <https://www.gnu.org/licenses/>.
 */

package baritone;

import baritone.api.IBaritone;
import baritone.api.utils.IPlayerController;
import baritone.utils.player.DummyEntityController;
import baritone.utils.player.EntityContext;
import baritone.utils.player.ServerPlayerController;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public final class AutomatoneComponents implements EntityComponentInitializer {
    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(LivingEntity.class, IBaritone.KEY, entity ->
                new Baritone(new EntityContext(entity), BaritoneProvider.INSTANCE.getWorldProvider(entity.world.getRegistryKey())));
        registry.registerFor(LivingEntity.class, IPlayerController.KEY, entity -> DummyEntityController.INSTANCE);
        registry.registerFor(ServerPlayerEntity.class, IPlayerController.KEY, ServerPlayerController::new);
    }
}
