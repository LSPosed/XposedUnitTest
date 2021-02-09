//
// Created by 双草酸酯 on 2/8/21.
//

#ifndef XPOSEDTEMPLATE_NATIVE_API_H
#define XPOSEDTEMPLATE_NATIVE_API_H

#include <cstdint>
#include <string>

typedef int (*HookFunType)(void *, void *, void **);  // For portability
typedef void (*LsposedNativeOnModuleLoaded) (const char* name, void* handle);
typedef void (*NativeInit)(void * init_func);
struct LsposedNativeAPIEntriesV1 {
    uint32_t version;
    HookFunType inlineHookFunc;
};
typedef LsposedNativeAPIEntriesV1 (*LSPInit)(LsposedNativeOnModuleLoaded);


#endif //XPOSEDTEMPLATE_NATIVE_API_H
