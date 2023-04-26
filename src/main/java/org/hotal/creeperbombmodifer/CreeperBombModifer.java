package org.hotal.creeperbombmodifer;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CreeperBombModifer extends JavaPlugin implements Listener {

    private double explosionRadius = 20.0; // 爆発範囲のデフォルト値

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this); // イベントリスナーを登録
    }

    @EventHandler
    public void onCreeperExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof Creeper) { // クリーパーの爆発であるかをチェック
            Creeper creeper = (Creeper) event.getEntity();
            event.setCancelled(true); // 爆発をキャンセル

            // 爆発範囲を変更
            double modifiedRadius = explosionRadius * 10; // 例えば、デフォルト値の2倍にする
            creeper.getWorld().createExplosion(creeper.getLocation(), (float) modifiedRadius);
        }
    }
}