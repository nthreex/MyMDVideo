# 开发日记
2016.6.12
- 在Application中添加Google multidex插件加载，方法数没这么快到65535，我只是添加玩一下

2016.6.14
- 调整toolbar为半透明风格。
- 增加播放控制，还在修改中

2016.6.15
- 修改播放页面的menu菜单，增加比例调节选项
- 阅读PLDroidPlayer文档，熟悉相关定制接口，下一步准备定制MediaController

2016.6.16
- 删除播放页面toolbar colorPrimary Alpha值得设定，API 21以后A TaskDescription's primary color should be opaque解决6.0机器上的崩溃问题（arthar）
- 修改沉浸式状态栏的适配。

2016.6.17
- 完善README文档

2016.6.20
- 更改包名为com.studyjams.mdvideo
- 删除原有PLDroidPlayer的jar、so包，播放器改用Google ExoPlayer.

2016.6.22
- 匹配播放页面的filter，支持点击SD卡中的视频拉起播放器。

2016.7.6
- 最小版本兼容提升至API 20,以便于更好的使用空间，省去适配兼容的麻烦。
- 更改主界面的框架，便于切换

