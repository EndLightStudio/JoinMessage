package net.endlight;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class joinmessage extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        this.getLogger().info("Join Message Plugin 加载完毕");
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getDataFolder().mkdirs(); //创建插件文件夹
        this.saveDefaultConfig(); //保存默认配置文件
        Config config = this.getConfig(); //读取默认配置文件
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Config config = this.getConfig();
        event.getPlayer().sendTip(config.getString("tip"));
        event.getPlayer().sendTitle(config.getString("title"));
        event.getPlayer().sendMessage(config.getString("message"));
    }
}
