import javax.swing.JOptionPane

onBootstrapEnd = { app ->
    app.addShutdownHandler([
        canShutdown: { app1 ->
            JOptionPane.showConfirmDialog(
                app.windowManager.windows.find {it.focused},
                    'Do you really want to exit?',
                    'Exit',
                    JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION
        },
        onShutdown: {}
    ] as griffon.core.ShutdownHandler)
}