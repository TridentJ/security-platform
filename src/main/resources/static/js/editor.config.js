/**
 Created by IntelliJ IDEA.
 User: trident
 Date: 2022/5/26
 Time: 22:33
 **/

// 编辑器配置
let { createEditor, createToolbar } = window.wangEditor
editorConfig={}
editorConfig.placeholder = '请输入内容'
editorConfig.onChange = (editor) => {
    // 当编辑器选区、内容变化时，即触发
    //console.log('content', editor.children)
    //console.log('html', editor.getHtml())
}

// 工具栏配置
toolbarConfig={
    excludeKeys: [
        'fullScreen'
    ]
}