//
// Created by 双草酸酯 on 2/8/21.
//
#include "logging.h"
#include "native_api.h"

static HookFunType hook_func = nullptr;

void on_library_loaded(const char* name, void* handle) {
    LOGI("Library loaded: %s @ %p", name, handle);
}

extern "C" __attribute__((visibility("default"))) void native_init(void* init) {
    auto lsp_init = reinterpret_cast<LSPInit>(init);
    auto apis = lsp_init(on_library_loaded);
    LOGI("LSP Native API v%d initialized with inline hooker %p", apis.version, apis.inlineHookFunc);
    hook_func = apis.inlineHookFunc;
}