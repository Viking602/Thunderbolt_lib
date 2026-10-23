# Thunderbolt_lib 26.1.2 源码构建（2026-10-17）

这是 `ae2lt_api` 附属 API 模组，独立于 Thunderbolt Core。
从 `Minecraft26.1.2neoforge` 分支 `a0b168386583fdae32c419b8b7ec95ccdfb17f2a` 继续移植，
补齐最新 1.21.1 `1.0.12-hotfix1`（`0bdda62aa67906f93fdeed0f8e999d7225eb3a0b`）的公开功能。

本地发行版本 `1.0.12-viking602.1+26.1.2`，冻结 API 版本仍为 `1.0.12-hotfix1`。
新增/修复内容：

- 恢复提供器 UI profile 桥接、公共入口及检测接口。
- 配方构建器使用 26.1 字符串/标签材料格式。
- 催化器支持 lightningCost、lightningTier 和 inputFluid。
- 版本判断可识别历史 26.1 alpha 及本次验证的主模组版本。
- 反射查找支持接口默认方法，避免漏掉 `IGrid#getStorageService`；保留内部 hook 的访问。
- 闪电读取使用原生可提取库存，模拟操作不改变账目；通过公共 MEStorage 接口调用具体存储实现。

4 项单元测试通过；主模组的真实配方 codec 合约测试覆盖六种 builder。
原生游戏测试验证了提供器 UI profile 和 HV/EHV 的原生/API 交叉存取、模拟与库存守恒。
按最新上游许可证保留 LGPL 正文并随 JAR 打包。

```powershell
. ..\devtools\env.ps1
.\gradlew.bat check jar --max-workers=2
```

完整来源及整包验证说明见同级 `AE2-Lightning-Tech/docs/source-build-26.1.2-viking602.md`。
