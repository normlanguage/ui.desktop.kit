# ui.desktop.kit Skill

Use this skill to work with Norm module `ui.desktop.kit` version 9. Use only declarations listed below.

## `ui.desktop.kit`

Source: `JavaArrays.norm`

### `JavaNodeArray`

```norm
class JavaNodeArray
```

#### `JavaNodeArray`

```norm
JavaNodeArray(JavaNodeArrayBindingToken token)
```

Parameters:

- `token`: `JavaNodeArrayBindingToken`

#### `size`

```norm
Integer size()
```

Returns: `Integer`

#### `get`

```norm
Node? get(Integer index)
```

Parameters:

- `index`: `Integer`

Returns: `Node?`

#### `set`

```norm
Void set(Integer index, Node? value)
```

Parameters:

- `index`: `Integer`
- `value`: `Node?`

Returns: `Void`

### `javaNodeArrayNew`

```norm
JavaNodeArray javaNodeArrayNew(Integer size)
```

Parameters:

- `size`: `Integer`

Returns: `JavaNodeArray`

### `JavaMenuItemArray`

```norm
class JavaMenuItemArray
```

#### `JavaMenuItemArray`

```norm
JavaMenuItemArray(JavaMenuItemArrayBindingToken token)
```

Parameters:

- `token`: `JavaMenuItemArrayBindingToken`

#### `size`

```norm
Integer size()
```

Returns: `Integer`

#### `get`

```norm
MenuItem? get(Integer index)
```

Parameters:

- `index`: `Integer`

Returns: `MenuItem?`

#### `set`

```norm
Void set(Integer index, MenuItem? value)
```

Parameters:

- `index`: `Integer`
- `value`: `MenuItem?`

Returns: `Void`

### `javaMenuItemArrayNew`

```norm
JavaMenuItemArray javaMenuItemArrayNew(Integer size)
```

Parameters:

- `size`: `Integer`

Returns: `JavaMenuItemArray`

### `JavaStringArray`

```norm
class JavaStringArray
```

#### `JavaStringArray`

```norm
JavaStringArray(JavaStringArrayBindingToken token)
```

Parameters:

- `token`: `JavaStringArrayBindingToken`

#### `size`

```norm
Integer size()
```

Returns: `Integer`

#### `get`

```norm
String? get(Integer index)
```

Parameters:

- `index`: `Integer`

Returns: `String?`

#### `set`

```norm
Void set(Integer index, String? value)
```

Parameters:

- `index`: `Integer`
- `value`: `String?`

Returns: `Void`

### `javaStringArrayNew`

```norm
JavaStringArray javaStringArrayNew(Integer size)
```

Parameters:

- `size`: `Integer`

Returns: `JavaStringArray`

### `JavaFloatButtonArray`

```norm
class JavaFloatButtonArray
```

#### `JavaFloatButtonArray`

```norm
JavaFloatButtonArray(JavaFloatButtonArrayBindingToken token)
```

Parameters:

- `token`: `JavaFloatButtonArrayBindingToken`

#### `size`

```norm
Integer size()
```

Returns: `Integer`

#### `get`

```norm
FloatButton? get(Integer index)
```

Parameters:

- `index`: `Integer`

Returns: `FloatButton?`

#### `set`

```norm
Void set(Integer index, FloatButton? value)
```

Parameters:

- `index`: `Integer`
- `value`: `FloatButton?`

Returns: `Void`

### `javaFloatButtonArrayNew`

```norm
JavaFloatButtonArray javaFloatButtonArrayNew(Integer size)
```

Parameters:

- `size`: `Integer`

Returns: `JavaFloatButtonArray`

## `ui.desktop.kit`

Source: `component_bridge.norm`

### `nativeComponent`

```norm
View nativeComponent<T>(String kind, Function<T()> create, Function<Node(T)> node, Function<Void(T, ViewScope)> update, Function<Void(T)> close, List<Widget> children, Function<Void(T, List<Node>)>? arrange, Function<List<Widget>(T)>? childrenBuilder, NodeKey? key, Boolean enabled, Function<Void(T, Theme?)>? applyTheme, Function<Void(T, UiConfiguration)>? applyConfiguration)
```

Type parameters:

- `T`

Parameters:

- `kind`: `String`
- `create`: `Function<T()>`
- `node`: `Function<Node(T)>`
- `update`: `Function<Void(T, ViewScope)>`
- `close`: `Function<Void(T)>`
- `children`: `List<Widget>`
- `arrange`: `Function<Void(T, List<Node>)>?`
- `childrenBuilder`: `Function<List<Widget>(T)>?`
- `key`: `NodeKey?`
- `enabled`: `Boolean`
- `applyTheme`: `Function<Void(T, Theme?)>?`
- `applyConfiguration`: `Function<Void(T, UiConfiguration)>?`

Returns: `View`

## `ui.desktop.kit`

Source: `configuration.norm`

### `App`

```norm
value App implements Widget
```

#### `theme`

```norm
ThemeSource theme
```

Type: `ThemeSource`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `config`

```norm
KitConfiguration? config
```

Type: `KitConfiguration?`

#### `stylesheet`

```norm
String? stylesheet
```

Type: `String?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `ConfigProvider`

```norm
value ConfigProvider implements Widget
```

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `theme`

```norm
ThemeSource? theme
```

Type: `ThemeSource?`

#### `config`

```norm
KitConfiguration? config
```

Type: `KitConfiguration?`

#### `stylesheet`

```norm
String? stylesheet
```

Type: `String?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `ComponentDensity`

```norm
enum ComponentDensity
```

#### `Compact`

```norm
Compact
```

#### `Standard`

```norm
Standard
```

#### `Spacious`

```norm
Spacious
```

### `KitConfiguration`

```norm
value KitConfiguration
```

#### `radius`

```norm
Double radius
```

Type: `Double`

#### `density`

```norm
ComponentDensity density
```

Type: `ComponentDensity`

## `ui.desktop.kit.dev.normlanguage.ui.component`

Source: `dev/normlanguage/ui/component/OverlayHost_Layer.norm`

### `OverlayHost_Layer`

```norm
class OverlayHost_Layer extends StackPane implements OverlayHost, EventTarget, Styleable
```

#### `OverlayHost_Layer`

```norm
OverlayHost_Layer(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit`

Source: `display.norm`

### `Avatar`

```norm
value Avatar implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `source`

```norm
String? source
```

Type: `String?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Badge`

```norm
value Badge implements Widget
```

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `count`

```norm
Integer count
```

Type: `Integer`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Calendar`

```norm
value Calendar implements Widget
```

#### `selected`

```norm
Binding<LocalDate?> selected
```

Type: `Binding<LocalDate?>`

#### `displayedMonth`

```norm
Binding<YearMonth>? displayedMonth
```

Type: `Binding<YearMonth>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Card`

```norm
value Card implements Widget
```

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `title`

```norm
String title
```

Type: `String`

#### `header`

```norm
Widget? header
```

Type: `Widget?`

#### `tone`

```norm
Tone tone
```

Type: `Tone`

#### `appearance`

```norm
Appearance appearance
```

Type: `Appearance`

#### `bottom`

```norm
Widget? bottom
```

Type: `Widget?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Carousel`

```norm
value Carousel implements Widget
```

#### `slides`

```norm
List<Widget> slides
```

Type: `List<Widget>`

#### `index`

```norm
Integer index
```

Type: `Integer`

#### `autoPlay`

```norm
Boolean autoPlay
```

Type: `Boolean`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Collapse`

```norm
value Collapse implements Widget
```

#### `title`

```norm
String title
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `expanded`

```norm
Binding<Boolean> expanded
```

Type: `Binding<Boolean>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Description`

```norm
value Description
```

#### `label`

```norm
String label
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

### `Descriptions`

```norm
value Descriptions implements Widget
```

#### `items`

```norm
List<Description> items
```

Type: `List<Description>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Empty`

```norm
value Empty implements Widget
```

#### `description`

```norm
String description
```

Type: `String`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Image`

```norm
value Image implements Widget
```

#### `source`

```norm
String source
```

Type: `String`

#### `previewable`

```norm
Boolean previewable
```

Type: `Boolean`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `ListView`

```norm
value ListView<T> implements Widget
```

Type parameters:

- `T`

#### `items`

```norm
List<T> items
```

Type: `List<T>`

#### `selected`

```norm
Binding<T?>? selected
```

Type: `Binding<T?>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Listy`

```norm
value Listy<T> implements Widget
```

Type parameters:

- `T`

#### `items`

```norm
List<T> items
```

Type: `List<T>`

#### `identity`

```norm
Function<ItemKey(T)> identity
```

Type: `Function<ItemKey(T)>`

#### `row`

```norm
Function<Widget(T)> row
```

Type: `Function<Widget(T)>`

#### `rowHeight`

```norm
Double rowHeight
```

Type: `Double`

#### `selected`

```norm
Binding<T?>? selected
```

Type: `Binding<T?>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `QRCode`

```norm
value QRCode implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `size`

```norm
Integer size
```

Type: `Integer`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Segmented`

```norm
value Segmented<T> implements Widget
```

Type parameters:

- `T`

#### `items`

```norm
List<T> items
```

Type: `List<T>`

#### `selected`

```norm
Binding<T?> selected
```

Type: `Binding<T?>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Statistic`

```norm
value Statistic implements Widget
```

#### `title`

```norm
String title
```

Type: `String`

#### `value`

```norm
Integer value
```

Type: `Integer`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `TableColumn`

```norm
value TableColumn<T>
```

Type parameters:

- `T`

#### `id`

```norm
String id
```

Type: `String`

#### `heading`

```norm
String heading
```

Type: `String`

#### `display`

```norm
Function<String(T)> display
```

Type: `Function<String(T)>`

#### `compare`

```norm
Function<Integer(T, T)>? compare
```

Type: `Function<Integer(T, T)>?`

#### `cell`

```norm
Function<Widget(T)>? cell
```

Type: `Function<Widget(T)>?`

### `TableSort`

```norm
value TableSort
```

#### `columnId`

```norm
String columnId
```

Type: `String`

#### `descending`

```norm
Boolean descending
```

Type: `Boolean`

### `Table`

```norm
value Table<T> implements Widget
```

Type parameters:

- `T`

#### `rows`

```norm
List<T> rows
```

Type: `List<T>`

#### `identity`

```norm
Function<ItemKey(T)> identity
```

Type: `Function<ItemKey(T)>`

#### `columns`

```norm
List<TableColumn<T>> columns
```

Type: `List<TableColumn<T>>`

#### `selected`

```norm
Binding<T?>? selected
```

Type: `Binding<T?>?`

#### `sort`

```norm
Binding<TableSort?>? sort
```

Type: `Binding<TableSort?>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Tag`

```norm
value Tag implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `tone`

```norm
Tone tone
```

Type: `Tone`

#### `appearance`

```norm
Appearance appearance
```

Type: `Appearance`

#### `closable`

```norm
Boolean closable
```

Type: `Boolean`

#### `onClose`

```norm
Function<Void()>? onClose
```

Type: `Function<Void()>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `TimelineEntry`

```norm
value TimelineEntry
```

#### `time`

```norm
String time
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

### `Timeline`

```norm
value Timeline implements Widget
```

#### `entries`

```norm
List<TimelineEntry> entries
```

Type: `List<TimelineEntry>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Tree`

```norm
value Tree<T> implements Widget
```

Type parameters:

- `T`

#### `root`

```norm
T root
```

Type: `T`

#### `children`

```norm
Function<List<T>(T)> children
```

Type: `Function<List<T>(T)>`

#### `selected`

```norm
Binding<T?>? selected
```

Type: `Binding<T?>?`

#### `checkable`

```norm
Boolean checkable
```

Type: `Boolean`

#### `checked`

```norm
Binding<List<T>>? checked
```

Type: `Binding<List<T>>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

## `ui.desktop.kit`

Source: `feedback.norm`

### `Modal`

```norm
value Modal implements Widget
```

#### `title`

```norm
String title
```

Type: `String`

#### `anchor`

```norm
Widget anchor
```

Type: `Widget`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `open`

```norm
Binding<Boolean> open
```

Type: `Binding<Boolean>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `DrawerSide`

```norm
enum DrawerSide
```

#### `Left`

```norm
Left
```

#### `Right`

```norm
Right
```

#### `Top`

```norm
Top
```

#### `Bottom`

```norm
Bottom
```

### `Drawer`

```norm
value Drawer implements Widget
```

#### `anchor`

```norm
Widget anchor
```

Type: `Widget`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `open`

```norm
Binding<Boolean> open
```

Type: `Binding<Boolean>`

#### `side`

```norm
DrawerSide side
```

Type: `DrawerSide`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Popover`

```norm
value Popover implements Widget
```

#### `anchor`

```norm
Widget anchor
```

Type: `Widget`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `open`

```norm
Binding<Boolean> open
```

Type: `Binding<Boolean>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Tooltip`

```norm
value Tooltip implements Widget
```

#### `anchor`

```norm
Widget anchor
```

Type: `Widget`

#### `text`

```norm
String text
```

Type: `String`

#### `open`

```norm
Binding<Boolean>? open
```

Type: `Binding<Boolean>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Popconfirm`

```norm
value Popconfirm implements Widget
```

#### `anchor`

```norm
Widget anchor
```

Type: `Widget`

#### `question`

```norm
String question
```

Type: `String`

#### `open`

```norm
Binding<Boolean> open
```

Type: `Binding<Boolean>`

#### `confirmed`

```norm
Function<Void()> confirmed
```

Type: `Function<Void()>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `TourStep`

```norm
value TourStep
```

#### `target`

```norm
Widget target
```

Type: `Widget`

#### `title`

```norm
String title
```

Type: `String`

#### `description`

```norm
String description
```

Type: `String`

### `Tour`

```norm
value Tour implements Widget
```

#### `steps`

```norm
List<TourStep> steps
```

Type: `List<TourStep>`

#### `open`

```norm
Binding<Boolean> open
```

Type: `Binding<Boolean>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

## `ui.desktop.kit`

Source: `form.norm`

### `FormEntry`

```norm
interface FormEntry
```

#### `name`

```norm
String name()
```

Returns: `String`

#### `validate`

```norm
Boolean validate()
```

Returns: `Boolean`

#### `dirty`

```norm
Boolean dirty()
```

Returns: `Boolean`

#### `reset`

```norm
Void reset()
```

Returns: `Void`

#### `begin`

```norm
Void begin()
```

Returns: `Void`

#### `accept`

```norm
Void accept()
```

Returns: `Void`

#### `reject`

```norm
Void reject(String error)
```

Parameters:

- `error`: `String`

Returns: `Void`

#### `view`

```norm
Widget view()
```

Returns: `Widget`

### `FormField`

```norm
class FormField<T> implements FormEntry
```

Type parameters:

- `T`

#### `FormField`

```norm
FormField(String name, Binding<T> value, Function<Widget(Binding<T>)> control, Function<Boolean(T)> validator, String error, Function<Boolean(T, T)> equivalent)
```

Parameters:

- `name`: `String`
- `value`: `Binding<T>`
- `control`: `Function<Widget(Binding<T>)>`
- `validator`: `Function<Boolean(T)>`
- `error`: `String`
- `equivalent`: `Function<Boolean(T, T)>`

#### `name`

```norm
String name()
```

Returns: `String`

#### `dirty`

```norm
Boolean dirty()
```

Returns: `Boolean`

#### `touched`

```norm
Boolean touched()
```

Returns: `Boolean`

#### `error`

```norm
String? error()
```

Returns: `String?`

#### `binding`

```norm
Binding<T> binding()
```

Returns: `Binding<T>`

#### `validate`

```norm
Boolean validate()
```

Returns: `Boolean`

#### `reset`

```norm
Void reset()
```

Returns: `Void`

#### `begin`

```norm
Void begin()
```

Returns: `Void`

#### `accept`

```norm
Void accept()
```

Returns: `Void`

#### `reject`

```norm
Void reject(String error)
```

Parameters:

- `error`: `String`

Returns: `Void`

#### `view`

```norm
Widget view()
```

Returns: `Widget`

### `FormSubmission`

```norm
class FormSubmission
```

#### `FormSubmission`

```norm
FormSubmission(Function<Void(Boolean, Map<String, String>, String?)> complete)
```

Parameters:

- `complete`: `Function<Void(Boolean, Map<String, String>, String?)>`

#### `accept`

```norm
Void accept()
```

Returns: `Void`

#### `reject`

```norm
Void reject(Map<String, String> fieldErrors, String? message)
```

Parameters:

- `fieldErrors`: `Map<String, String>`
- `message`: `String?`

Returns: `Void`

#### `cancel`

```norm
Void cancel()
```

Returns: `Void`

### `FormController`

```norm
class FormController
```

#### `FormController`

```norm
FormController(List<FormEntry> fields)
```

Parameters:

- `fields`: `List<FormEntry>`

#### `pending`

```norm
Boolean pending()
```

Returns: `Boolean`

#### `entries`

```norm
List<FormEntry> entries()
```

Returns: `List<FormEntry>`

#### `message`

```norm
String? message()
```

Returns: `String?`

#### `dirty`

```norm
Boolean dirty()
```

Returns: `Boolean`

#### `validate`

```norm
Boolean validate()
```

Returns: `Boolean`

#### `submit`

```norm
Boolean submit(Function<Void(FormSubmission)> onSubmit)
```

Parameters:

- `onSubmit`: `Function<Void(FormSubmission)>`

Returns: `Boolean`

#### `cancel`

```norm
Void cancel()
```

Returns: `Void`

#### `reset`

```norm
Void reset()
```

Returns: `Void`

### `Form`

```norm
value Form implements Widget
```

#### `controller`

```norm
FormController controller
```

Type: `FormController`

#### `onSubmit`

```norm
Function<Void(FormSubmission)> onSubmit
```

Type: `Function<Void(FormSubmission)>`

#### `submitText`

```norm
String submitText
```

Type: `String`

#### `resetText`

```norm
String resetText
```

Type: `String`

#### `validate`

```norm
Boolean validate()
```

Returns: `Boolean`

#### `submit`

```norm
Boolean submit()
```

Returns: `Boolean`

#### `reset`

```norm
Void reset()
```

Returns: `Void`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

## `ui.desktop.kit`

Source: `general.norm`

### `Button`

```norm
value Button implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `action`

```norm
Function<Void()> action
```

Type: `Function<Void()>`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `loading`

```norm
Boolean loading
```

Type: `Boolean`

#### `tone`

```norm
Tone tone
```

Type: `Tone`

#### `appearance`

```norm
Appearance appearance
```

Type: `Appearance`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `FloatButton`

```norm
value FloatButton implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `action`

```norm
Function<Void()> action
```

Type: `Function<Void()>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Icon`

```norm
value Icon implements Widget
```

#### `literal`

```norm
String literal
```

Type: `String`

#### `size`

```norm
Integer size
```

Type: `Integer`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Typography`

```norm
value Typography implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `copyable`

```norm
Boolean copyable
```

Type: `Boolean`

#### `edited`

```norm
Binding<String>? edited
```

Type: `Binding<String>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

## `ui.desktop.kit`

Source: `inputs.norm`

### `Input`

```norm
value Input implements Widget
```

#### `placeholder`

```norm
String placeholder
```

Type: `String`

#### `value`

```norm
Binding<String> value
```

Type: `Binding<String>`

#### `submit`

```norm
Function<Void()>? submit
```

Type: `Function<Void()>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `password`

```norm
Boolean password
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Checkbox`

```norm
value Checkbox implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `value`

```norm
Binding<Boolean> value
```

Type: `Binding<Boolean>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Radio`

```norm
value Radio implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `value`

```norm
Binding<Boolean> value
```

Type: `Binding<Boolean>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Switch`

```norm
value Switch implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `value`

```norm
Binding<Boolean> value
```

Type: `Binding<Boolean>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Mentions`

```norm
value Mentions implements Widget
```

#### `value`

```norm
Binding<String> value
```

Type: `Binding<String>`

#### `suggestions`

```norm
List<String> suggestions
```

Type: `List<String>`

#### `placeholder`

```norm
String placeholder
```

Type: `String`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `AutoComplete`

```norm
value AutoComplete implements Widget
```

#### `placeholder`

```norm
String placeholder
```

Type: `String`

#### `value`

```norm
Binding<String> value
```

Type: `Binding<String>`

#### `suggestions`

```norm
List<String> suggestions
```

Type: `List<String>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `DatePicker`

```norm
value DatePicker implements Widget
```

#### `value`

```norm
Binding<LocalDate?> value
```

Type: `Binding<LocalDate?>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `TimePicker`

```norm
value TimePicker implements Widget
```

#### `value`

```norm
Binding<LocalTime?> value
```

Type: `Binding<LocalTime?>`

#### `minuteStep`

```norm
Integer minuteStep
```

Type: `Integer`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `InputNumber`

```norm
value InputNumber implements Widget
```

#### `value`

```norm
Binding<BigDecimal> value
```

Type: `Binding<BigDecimal>`

#### `scale`

```norm
Integer? scale
```

Type: `Integer?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Rate`

```norm
value Rate implements Widget
```

#### `value`

```norm
Binding<Integer> value
```

Type: `Binding<Integer>`

#### `maximum`

```norm
Integer maximum
```

Type: `Integer`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Slider`

```norm
value Slider implements Widget
```

#### `value`

```norm
Binding<Double> value
```

Type: `Binding<Double>`

#### `minimum`

```norm
Double minimum
```

Type: `Double`

#### `maximum`

```norm
Double maximum
```

Type: `Double`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `ColorPicker`

```norm
value ColorPicker implements Widget
```

#### `hex`

```norm
Binding<String> hex
```

Type: `Binding<String>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Select`

```norm
value Select<T> implements Widget
```

Type parameters:

- `T`

#### `options`

```norm
List<T> options
```

Type: `List<T>`

#### `value`

```norm
Binding<T?> value
```

Type: `Binding<T?>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `CascaderOption`

```norm
value CascaderOption<T>
```

Type parameters:

- `T`

#### `value`

```norm
T value
```

Type: `T`

#### `label`

```norm
String label
```

Type: `String`

#### `children`

```norm
List<CascaderOption<T>> children
```

Type: `List<CascaderOption<T>>`

### `Cascader`

```norm
value Cascader<T> implements Widget
```

Type parameters:

- `T`

#### `options`

```norm
List<CascaderOption<T>> options
```

Type: `List<CascaderOption<T>>`

#### `value`

```norm
Binding<List<T>> value
```

Type: `Binding<List<T>>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `TreeOption`

```norm
value TreeOption<T>
```

Type parameters:

- `T`

#### `value`

```norm
T value
```

Type: `T`

#### `children`

```norm
List<TreeOption<T>> children
```

Type: `List<TreeOption<T>>`

### `TreeSelect`

```norm
value TreeSelect<T> implements Widget
```

Type parameters:

- `T`

#### `options`

```norm
List<TreeOption<T>> options
```

Type: `List<TreeOption<T>>`

#### `value`

```norm
Binding<T?> value
```

Type: `Binding<T?>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Transfer`

```norm
value Transfer<T> implements Widget
```

Type parameters:

- `T`

#### `options`

```norm
List<T> options
```

Type: `List<T>`

#### `value`

```norm
Binding<List<T>> value
```

Type: `Binding<List<T>>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Upload`

```norm
value Upload implements Widget
```

#### `uploader`

```norm
Function<Task<Unit?>(Path, Function<Void(Double)>)> uploader
```

Type: `Function<Task<Unit?>(Path, Function<Void(Double)>)>`

#### `files`

```norm
List<Path> files
```

Type: `List<Path>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `MultipleSelect`

```norm
value MultipleSelect<T> implements Widget
```

Type parameters:

- `T`

#### `options`

```norm
List<T> options
```

Type: `List<T>`

#### `value`

```norm
Binding<List<T>> value
```

Type: `Binding<List<T>>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `SearchSelect`

```norm
value SearchSelect<T> implements Widget
```

Type parameters:

- `T`

#### `options`

```norm
List<T> options
```

Type: `List<T>`

#### `value`

```norm
Binding<T?> value
```

Type: `Binding<T?>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `DateRange`

```norm
value DateRange
```

#### `start`

```norm
LocalDate? start
```

Type: `LocalDate?`

#### `end`

```norm
LocalDate? end
```

Type: `LocalDate?`

### `DateRangePicker`

```norm
value DateRangePicker implements Widget
```

#### `value`

```norm
Binding<DateRange> value
```

Type: `Binding<DateRange>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `NumericRange`

```norm
value NumericRange
```

#### `start`

```norm
Double start
```

Type: `Double`

#### `end`

```norm
Double end
```

Type: `Double`

### `RangeSlider`

```norm
value RangeSlider implements Widget
```

#### `value`

```norm
Binding<NumericRange> value
```

Type: `Binding<NumericRange>`

#### `minimum`

```norm
Double minimum
```

Type: `Double`

#### `maximum`

```norm
Double maximum
```

Type: `Double`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `enabled`

```norm
Boolean enabled
```

Type: `Boolean`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

## `ui.desktop.kit.internal`

Source: `internal/Affix.norm`

### `Affix`

```norm
class Affix extends StackPane implements AutoCloseable, EventTarget, Styleable
```

#### `Affix`

```norm
Affix(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

### `affixNew`

```norm
Affix affixNew(ScrollPane? arg0, Node? arg1)
```

Parameters:

- `arg0`: `ScrollPane?`
- `arg1`: `Node?`

Returns: `Affix`

## `ui.desktop.kit.internal`

Source: `internal/AffixHost.norm`

### `AffixHost`

```norm
class AffixHost extends ScrollPane implements AutoCloseable, Skinnable, EventTarget, Styleable
```

#### `AffixHost`

```norm
AffixHost(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `content`

```norm
Void content(Node? arg0, Node? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Node?`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/Alert.norm`

### `Alert`

```norm
class Alert extends HBox implements EventTarget, Styleable
```

#### `Alert`

```norm
Alert(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `dismiss`

```norm
Void dismiss()
```

Returns: `Void`

#### `setClosable`

```norm
Void setClosable(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setContent`

```norm
Void setContent(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

#### `setTitle`

```norm
Void setTitle(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `alertNew`

```norm
Alert alertNew(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `Alert`

## `ui.desktop.kit.internal`

Source: `internal/Anchor.norm`

### `Anchor`

```norm
class Anchor extends VBox implements AutoCloseable, EventTarget, Styleable
```

#### `Anchor`

```norm
Anchor(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getActiveItem`

```norm
AnchorItem? getActiveItem()
```

Returns: `AnchorItem?`

#### `getItems`

```norm
ObservableList<AnchorItem>? getItems()
```

Returns: `ObservableList<AnchorItem>?`

#### `scrollTo`

```norm
Void scrollTo(AnchorItem? arg0)
```

Parameters:

- `arg0`: `AnchorItem?`

Returns: `Void`

### `anchorNew`

```norm
Anchor anchorNew(ScrollPane? arg0)
```

Parameters:

- `arg0`: `ScrollPane?`

Returns: `Anchor`

## `ui.desktop.kit.internal`

Source: `internal/AnchorHost.norm`

### `AnchorHost`

```norm
class AnchorHost extends HBox implements AutoCloseable, EventTarget, Styleable
```

#### `AnchorHost`

```norm
AnchorHost(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `anchor`

```norm
Anchor? anchor()
```

Returns: `Anchor?`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `scrollPane`

```norm
ScrollPane? scrollPane()
```

Returns: `ScrollPane?`

## `ui.desktop.kit.internal`

Source: `internal/AnchorItem.norm`

### `AnchorItem`

```norm
class AnchorItem extends Record
```

#### `AnchorItem`

```norm
AnchorItem(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `target`

```norm
Node? target()
```

Returns: `Node?`

#### `text`

```norm
String? text()
```

Returns: `String?`

### `anchorItemNew`

```norm
AnchorItem anchorItemNew(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `AnchorItem`

## `ui.desktop.kit.internal`

Source: `internal/App.norm`

### `App`

```norm
class App extends ConfigProvider implements OverlayHost, AutoCloseable, EventTarget, Styleable
```

#### `App`

```norm
App(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getContent`

```norm
Node? getContent()
```

Returns: `Node?`

#### `getMessages`

```norm
Message? getMessages()
```

Returns: `Message?`

#### `getNotifications`

```norm
Notification? getNotifications()
```

Returns: `Notification?`

#### `getThemeCss`

```norm
String? getThemeCss()
```

Returns: `String?`

#### `isClosed`

```norm
Boolean isClosed()
```

Returns: `Boolean`

#### `onClose`

```norm
Void onClose(Function<Void()>? arg0)
```

Parameters:

- `arg0`: `Function<Void()>?`

Returns: `Void`

#### `publishTheme`

```norm
Void publishTheme(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setContent`

```norm
Void setContent(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

### `appNew`

```norm
App appNew()
```

Returns: `App`

### `appNew`

```norm
App appNew(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `App`

### `appNew`

```norm
App appNew(Node? arg0, ContentOwnership? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `ContentOwnership?`

Returns: `App`

## `ui.desktop.kit.internal`

Source: `internal/AutoComplete.norm`

### `AutoComplete`

```norm
class AutoComplete extends ComboBox<String> implements Skinnable, EventTarget, Styleable
```

#### `AutoComplete`

```norm
AutoComplete(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getEditor`

```norm
TextField? getEditor()
```

Returns: `TextField?`

#### `getSuggestions`

```norm
ObservableList<String>? getSuggestions()
```

Returns: `ObservableList<String>?`

#### `getValue`

```norm
String? getValue()
```

Returns: `String?`

#### `isLoading`

```norm
Boolean isLoading()
```

Returns: `Boolean`

#### `loadingProperty`

```norm
BooleanProperty? loadingProperty()
```

Returns: `BooleanProperty?`

#### `setPromptText`

```norm
Void setPromptText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setProvider`

```norm
Void setProvider(Function<CompletableFuture<JavaList<String>>?(String?)>? arg0)
```

Parameters:

- `arg0`: `Function<CompletableFuture<JavaList<String>>?(String?)>?`

Returns: `Void`

#### `setSuggestions`

```norm
Void setSuggestions(JavaList<String>? arg0)
```

Parameters:

- `arg0`: `JavaList<String>?`

Returns: `Void`

### `autoCompleteNew`

```norm
AutoComplete autoCompleteNew()
```

Returns: `AutoComplete`

## `ui.desktop.kit.internal`

Source: `internal/Avatar.norm`

### `Avatar`

```norm
class Avatar extends StackPane implements EventTarget, Styleable
```

#### `Avatar`

```norm
Avatar(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `setImage`

```norm
Void setImage(Image? arg0)
```

Parameters:

- `arg0`: `Image?`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `avatarNew`

```norm
Avatar avatarNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Avatar`

## `ui.desktop.kit.internal`

Source: `internal/Badge.norm`

### `Badge`

```norm
class Badge extends StackPane implements EventTarget, Styleable
```

#### `Badge`

```norm
Badge(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getCount`

```norm
Integer getCount()
```

Returns: `Integer`

#### `setCount`

```norm
Void setCount(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

### `badgeNew`

```norm
Badge badgeNew(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Badge`

## `ui.desktop.kit.internal`

Source: `internal/BorderBeam.norm`

### `BorderBeam`

```norm
class BorderBeam extends StackPane implements AutoCloseable, EventTarget, Styleable
```

#### `BorderBeam`

```norm
BorderBeam(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `setAnimated`

```norm
Void setAnimated(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setContent`

```norm
Void setContent(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

### `borderBeamNew`

```norm
BorderBeam borderBeamNew(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `BorderBeam`

## `ui.desktop.kit.internal`

Source: `internal/Breadcrumb.norm`

### `Breadcrumb`

```norm
class Breadcrumb extends HBox implements EventTarget, Styleable
```

#### `Breadcrumb`

```norm
Breadcrumb(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getItems`

```norm
ObservableList<BreadcrumbItem>? getItems()
```

Returns: `ObservableList<BreadcrumbItem>?`

### `breadcrumbNew`

```norm
Breadcrumb breadcrumbNew()
```

Returns: `Breadcrumb`

## `ui.desktop.kit.internal`

Source: `internal/BreadcrumbItem.norm`

### `BreadcrumbItem`

```norm
class BreadcrumbItem extends Record
```

#### `BreadcrumbItem`

```norm
BreadcrumbItem(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `text`

```norm
String? text()
```

Returns: `String?`

### `breadcrumbItemNew`

```norm
BreadcrumbItem breadcrumbItemNew(String? arg0, Function<Void()>? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Function<Void()>?`

Returns: `BreadcrumbItem`

## `ui.desktop.kit.internal`

Source: `internal/Button.norm`

### `Button`

```norm
class Button extends ButtonImported1 implements AutoCloseable, Skinnable, EventTarget, Styleable
```

#### `Button`

```norm
Button(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `fire`

```norm
Void fire()
```

Returns: `Void`

#### `getStyle`

```norm
String? getStyle()
```

Returns: `String?`

#### `isLoading`

```norm
Boolean isLoading()
```

Returns: `Boolean`

#### `setLoading`

```norm
Void setLoading(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setOnAction`

```norm
Void setOnAction(Function<Void(ActionEvent?)>? arg0)
```

Parameters:

- `arg0`: `Function<Void(ActionEvent?)>?`

Returns: `Void`

#### `setStyle`

```norm
Void setStyle(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `buttonNew`

```norm
Button buttonNew()
```

Returns: `Button`

### `buttonNew`

```norm
Button buttonNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Button`

## `ui.desktop.kit.internal`

Source: `internal/Calendar.norm`

### `Calendar`

```norm
class Calendar extends BorderPane implements AutoCloseable, EventTarget, Styleable
```

#### `Calendar`

```norm
Calendar(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getDisplayedMonth`

```norm
YearMonth? getDisplayedMonth()
```

Returns: `YearMonth?`

#### `getValue`

```norm
LocalDate? getValue()
```

Returns: `LocalDate?`

#### `nextMonth`

```norm
Void nextMonth()
```

Returns: `Void`

#### `previousMonth`

```norm
Void previousMonth()
```

Returns: `Void`

#### `setDayContentFactory`

```norm
Void setDayContentFactory(Function<Node?(LocalDate?)>? arg0)
```

Parameters:

- `arg0`: `Function<Node?(LocalDate?)>?`

Returns: `Void`

#### `setDisplayedMonth`

```norm
Void setDisplayedMonth(YearMonth? arg0)
```

Parameters:

- `arg0`: `YearMonth?`

Returns: `Void`

#### `setValue`

```norm
Void setValue(LocalDate? arg0)
```

Parameters:

- `arg0`: `LocalDate?`

Returns: `Void`

### `calendarNew`

```norm
Calendar calendarNew()
```

Returns: `Calendar`

## `ui.desktop.kit.internal`

Source: `internal/Card.norm`

### `Card`

```norm
class Card extends BorderPane implements EventTarget, Styleable
```

#### `Card`

```norm
Card(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `setBottom`

```norm
Void setBottom(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

#### `setHeader`

```norm
Void setHeader(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

#### `setTitle`

```norm
Void setTitle(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `cardNew`

```norm
Card cardNew(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `Card`

## `ui.desktop.kit.internal`

Source: `internal/Carousel.norm`

### `Carousel`

```norm
class Carousel extends StackPane implements AutoCloseable, EventTarget, Styleable
```

#### `Carousel`

```norm
Carousel(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getIndex`

```norm
Integer getIndex()
```

Returns: `Integer`

#### `getSlides`

```norm
ObservableList<Node>? getSlides()
```

Returns: `ObservableList<Node>?`

#### `next`

```norm
Void next()
```

Returns: `Void`

#### `previous`

```norm
Void previous()
```

Returns: `Void`

#### `setAutoPlay`

```norm
Void setAutoPlay(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setIndex`

```norm
Void setIndex(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

### `carouselNew`

```norm
Carousel carouselNew()
```

Returns: `Carousel`

### `carouselNew`

```norm
Carousel carouselNew(JavaList<Node>? arg0)
```

Parameters:

- `arg0`: `JavaList<Node>?`

Returns: `Carousel`

## `ui.desktop.kit.internal`

Source: `internal/Cascader.norm`

### `Cascader`

```norm
class Cascader<T> extends HBox implements EventTarget, Styleable
```

Type parameters:

- `T`

#### `Cascader`

```norm
Cascader(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getItems`

```norm
ObservableList<CascaderItem<T>>? getItems()
```

Returns: `ObservableList<CascaderItem<T>>?`

#### `getValue`

```norm
JavaList<T>? getValue()
```

Returns: `JavaList<T>?`

#### `selectPath`

```norm
Void selectPath(JavaList<T>? arg0)
```

Parameters:

- `arg0`: `JavaList<T>?`

Returns: `Void`

#### `setChildrenProvider`

```norm
Void setChildrenProvider(Function<CompletableFuture<JavaList<CascaderItem<T>>>?(CascaderItem<T>?)>? arg0)
```

Parameters:

- `arg0`: `Function<CompletableFuture<JavaList<CascaderItem<T>>>?(CascaderItem<T>?)>?`

Returns: `Void`

#### `valueProperty`

```norm
ReadOnlyObjectProperty<JavaList<T>>? valueProperty()
```

Returns: `ReadOnlyObjectProperty<JavaList<T>>?`

### `cascaderNew`

```norm
Cascader<T> cascaderNew<T>(JavaList<CascaderItem<T>>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `JavaList<CascaderItem<T>>?`

Returns: `Cascader<T>`

## `ui.desktop.kit.internal`

Source: `internal/CascaderItem.norm`

### `CascaderItem`

```norm
class CascaderItem<T> extends Record
```

Type parameters:

- `T`

#### `CascaderItem`

```norm
CascaderItem(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `children`

```norm
JavaList<CascaderItem<T>>? children()
```

Returns: `JavaList<CascaderItem<T>>?`

#### `label`

```norm
String? label()
```

Returns: `String?`

#### `value`

```norm
T? value()
```

Returns: `T?`

### `cascaderItemNew`

```norm
CascaderItem<T> cascaderItemNew<T>(T? arg0, String? arg1, JavaList<CascaderItem<T>>? arg2)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `T?`
- `arg1`: `String?`
- `arg2`: `JavaList<CascaderItem<T>>?`

Returns: `CascaderItem<T>`

### `cascaderItemNew`

```norm
CascaderItem<T> cascaderItemNew<T>(T? arg0, String? arg1, JavaList<CascaderItem<T>>? arg2, Boolean arg3)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `T?`
- `arg1`: `String?`
- `arg2`: `JavaList<CascaderItem<T>>?`
- `arg3`: `Boolean`

Returns: `CascaderItem<T>`

## `ui.desktop.kit.internal`

Source: `internal/Checkbox.norm`

### `Checkbox`

```norm
class Checkbox extends CheckBox implements Skinnable, EventTarget, Styleable
```

#### `Checkbox`

```norm
Checkbox(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `isIndeterminate`

```norm
Boolean isIndeterminate()
```

Returns: `Boolean`

#### `isSelected`

```norm
Boolean isSelected()
```

Returns: `Boolean`

#### `selectedProperty`

```norm
BooleanProperty? selectedProperty()
```

Returns: `BooleanProperty?`

#### `setIndeterminate`

```norm
Void setIndeterminate(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setSelected`

```norm
Void setSelected(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `checkboxNew`

```norm
Checkbox checkboxNew()
```

Returns: `Checkbox`

### `checkboxNew`

```norm
Checkbox checkboxNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Checkbox`

## `ui.desktop.kit.internal`

Source: `internal/Collapse.norm`

### `Collapse`

```norm
class Collapse extends TitledPane implements AutoCloseable, Skinnable, EventTarget, Styleable
```

#### `Collapse`

```norm
Collapse(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `isExpanded`

```norm
Boolean isExpanded()
```

Returns: `Boolean`

#### `setExpanded`

```norm
Void setExpanded(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

### `collapseNew`

```norm
Collapse collapseNew(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `Collapse`

## `ui.desktop.kit.internal`

Source: `internal/ColorPicker.norm`

### `ColorPicker`

```norm
class ColorPicker extends HBox implements EventTarget, Styleable
```

#### `ColorPicker`

```norm
ColorPicker(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getValue`

```norm
Color? getValue()
```

Returns: `Color?`

#### `setValue`

```norm
Void setValue(Color? arg0)
```

Parameters:

- `arg0`: `Color?`

Returns: `Void`

#### `valueProperty`

```norm
ObjectProperty<Color>? valueProperty()
```

Returns: `ObjectProperty<Color>?`

### `colorPickerNew`

```norm
ColorPicker colorPickerNew()
```

Returns: `ColorPicker`

## `ui.desktop.kit.internal`

Source: `internal/ComponentConfig.norm`

### `ComponentConfig`

```norm
class ComponentConfig extends Record
```

#### `ComponentConfig`

```norm
ComponentConfig(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `density`

```norm
Density? density()
```

Returns: `Density?`

#### `fontFamily`

```norm
String? fontFamily()
```

Returns: `String?`

#### `fontSize`

```norm
Double fontSize()
```

Returns: `Double`

#### `locale`

```norm
Locale? locale()
```

Returns: `Locale?`

#### `motionEnabled`

```norm
Boolean motionEnabled()
```

Returns: `Boolean`

#### `radius`

```norm
Double radius()
```

Returns: `Double`

### `componentConfigNew`

```norm
ComponentConfig componentConfigNew(String? arg0, Double arg1, Density? arg2, Double arg3, Boolean arg4, Locale? arg5)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Double`
- `arg2`: `Density?`
- `arg3`: `Double`
- `arg4`: `Boolean`
- `arg5`: `Locale?`

Returns: `ComponentConfig`

### `componentConfigDefaults`

```norm
ComponentConfig? componentConfigDefaults()
```

Returns: `ComponentConfig?`

## `ui.desktop.kit.internal`

Source: `internal/ConfigProvider.norm`

### `ConfigProvider`

```norm
class ConfigProvider extends StackPane implements AutoCloseable, EventTarget, Styleable
```

#### `ConfigProvider`

```norm
ConfigProvider(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `clearTheme`

```norm
Void clearTheme()
```

Returns: `Void`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getConfig`

```norm
ComponentConfig? getConfig()
```

Returns: `ComponentConfig?`

#### `getContent`

```norm
Node? getContent()
```

Returns: `Node?`

#### `getEffectiveConfig`

```norm
ComponentConfig? getEffectiveConfig()
```

Returns: `ComponentConfig?`

#### `getThemeCss`

```norm
String? getThemeCss()
```

Returns: `String?`

#### `publishTheme`

```norm
Void publishTheme(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setConfig`

```norm
Void setConfig(ComponentConfig? arg0)
```

Parameters:

- `arg0`: `ComponentConfig?`

Returns: `Void`

#### `setContent`

```norm
Void setContent(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

#### `setStylesheet`

```norm
Void setStylesheet(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setThemeCss`

```norm
Void setThemeCss(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `configProviderNew`

```norm
ConfigProvider configProviderNew()
```

Returns: `ConfigProvider`

### `configProviderNew`

```norm
ConfigProvider configProviderNew(ContentOwnership? arg0)
```

Parameters:

- `arg0`: `ContentOwnership?`

Returns: `ConfigProvider`

### `configProviderNew`

```norm
ConfigProvider configProviderNew(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `ConfigProvider`

### `configProviderNew`

```norm
ConfigProvider configProviderNew(Node? arg0, ContentOwnership? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `ContentOwnership?`

Returns: `ConfigProvider`

## `ui.desktop.kit.internal`

Source: `internal/ContentOwnership.norm`

### `ContentOwnership`

```norm
enum ContentOwnership
```

#### `EXTERNAL`

```norm
EXTERNAL
```

#### `OWNED`

```norm
OWNED
```

## `ui.desktop.kit.internal`

Source: `internal/DatePicker.norm`

### `DatePicker`

```norm
class DatePicker extends DatePickerImported1 implements Skinnable, EventTarget, Styleable
```

#### `DatePicker`

```norm
DatePicker(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getValue`

```norm
LocalDate? getValue()
```

Returns: `LocalDate?`

#### `setValue`

```norm
Void setValue(LocalDate? arg0)
```

Parameters:

- `arg0`: `LocalDate?`

Returns: `Void`

#### `valueProperty`

```norm
ObjectProperty<LocalDate>? valueProperty()
```

Returns: `ObjectProperty<LocalDate>?`

### `datePickerNew`

```norm
DatePicker datePickerNew()
```

Returns: `DatePicker`

## `ui.desktop.kit.internal`

Source: `internal/DatePickerRange.norm`

### `DatePickerRange`

```norm
class DatePickerRange extends HBox implements EventTarget, Styleable
```

#### `DatePickerRange`

```norm
DatePickerRange(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getEndPicker`

```norm
DatePicker? getEndPicker()
```

Returns: `DatePicker?`

#### `getStartPicker`

```norm
DatePicker? getStartPicker()
```

Returns: `DatePicker?`

#### `getValue`

```norm
DateRange? getValue()
```

Returns: `DateRange?`

#### `setValue`

```norm
Void setValue(DateRange? arg0)
```

Parameters:

- `arg0`: `DateRange?`

Returns: `Void`

#### `valueProperty`

```norm
ObjectProperty<DateRange>? valueProperty()
```

Returns: `ObjectProperty<DateRange>?`

### `datePickerRangeNew`

```norm
DatePickerRange datePickerRangeNew()
```

Returns: `DatePickerRange`

## `ui.desktop.kit.internal`

Source: `internal/DateRange.norm`

### `DateRange`

```norm
class DateRange extends Record
```

#### `DateRange`

```norm
DateRange(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `end`

```norm
LocalDate? end()
```

Returns: `LocalDate?`

#### `start`

```norm
LocalDate? start()
```

Returns: `LocalDate?`

### `dateRangeNew`

```norm
DateRange dateRangeNew(LocalDate? arg0, LocalDate? arg1)
```

Parameters:

- `arg0`: `LocalDate?`
- `arg1`: `LocalDate?`

Returns: `DateRange`

## `ui.desktop.kit.internal`

Source: `internal/Density.norm`

### `Density`

```norm
enum Density
```

#### `COMPACT`

```norm
COMPACT
```

#### `SPACIOUS`

```norm
SPACIOUS
```

#### `STANDARD`

```norm
STANDARD
```

## `ui.desktop.kit.internal`

Source: `internal/Descriptions.norm`

### `Descriptions`

```norm
class Descriptions extends GridPane implements EventTarget, Styleable
```

#### `Descriptions`

```norm
Descriptions(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `add`

```norm
Void add(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `Void`

#### `add`

```norm
Void add(Node? arg0, Integer arg1, Integer arg2)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Integer`
- `arg2`: `Integer`

Returns: `Void`

#### `add`

```norm
Void add(Node? arg0, Integer arg1, Integer arg2, Integer arg3, Integer arg4)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Integer`
- `arg2`: `Integer`
- `arg3`: `Integer`
- `arg4`: `Integer`

Returns: `Void`

### `descriptionsNew`

```norm
Descriptions descriptionsNew()
```

Returns: `Descriptions`

## `ui.desktop.kit.internal`

Source: `internal/DisplayAdapter.norm`

### `DisplayAdapter`

```norm
class DisplayAdapter
```

#### `DisplayAdapter`

```norm
DisplayAdapter(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

### `displayAdapterAvatarSource`

```norm
Void displayAdapterAvatarSource(Avatar? arg0, String? arg1)
```

Parameters:

- `arg0`: `Avatar?`
- `arg1`: `String?`

Returns: `Void`

### `displayAdapterBadge`

```norm
Badge? displayAdapterBadge()
```

Returns: `Badge?`

### `displayAdapterBadgeContent`

```norm
Void displayAdapterBadgeContent(Badge? arg0, Node? arg1)
```

Parameters:

- `arg0`: `Badge?`
- `arg1`: `Node?`

Returns: `Void`

### `displayAdapterCalendarMonth`

```norm
ValueLink<YearMonth>? displayAdapterCalendarMonth(Calendar? arg0)
```

Parameters:

- `arg0`: `Calendar?`

Returns: `ValueLink<YearMonth>?`

### `displayAdapterCalendarValue`

```norm
ValueLink<LocalDate>? displayAdapterCalendarValue(Calendar? arg0)
```

Parameters:

- `arg0`: `Calendar?`

Returns: `ValueLink<LocalDate>?`

### `displayAdapterCard`

```norm
Card? displayAdapterCard(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Card?`

### `displayAdapterCardContent`

```norm
Void displayAdapterCardContent(Card? arg0, Node? arg1)
```

Parameters:

- `arg0`: `Card?`
- `arg1`: `Node?`

Returns: `Void`

### `displayAdapterCardSlots`

```norm
Void displayAdapterCardSlots(Card? arg0, Node? arg1, Node? arg2)
```

Parameters:

- `arg0`: `Card?`
- `arg1`: `Node?`
- `arg2`: `Node?`

Returns: `Void`

### `displayAdapterCarouselSlides`

```norm
Void displayAdapterCarouselSlides(Carousel? arg0, JavaList<Node>? arg1)
```

Parameters:

- `arg0`: `Carousel?`
- `arg1`: `JavaList<Node>?`

Returns: `Void`

### `displayAdapterCollapse`

```norm
Collapse? displayAdapterCollapse(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Collapse?`

### `displayAdapterCollapseContent`

```norm
Void displayAdapterCollapseContent(Collapse? arg0, Node? arg1)
```

Parameters:

- `arg0`: `Collapse?`
- `arg1`: `Node?`

Returns: `Void`

### `displayAdapterCollapseExpanded`

```norm
ValueLink<Boolean>? displayAdapterCollapseExpanded(Collapse? arg0)
```

Parameters:

- `arg0`: `Collapse?`

Returns: `ValueLink<Boolean>?`

### `displayAdapterColumn`

```norm
TableColumn<T, String>? displayAdapterColumn<T>(Table<T>? arg0, String? arg1, Function<String?(T?)>? arg2)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Table<T>?`
- `arg1`: `String?`
- `arg2`: `Function<String?(T?)>?`

Returns: `TableColumn<T, String>?`

### `displayAdapterDescriptions`

```norm
Void displayAdapterDescriptions(Descriptions? arg0, JavaList<String>? arg1, JavaList<Node>? arg2)
```

Parameters:

- `arg0`: `Descriptions?`
- `arg1`: `JavaList<String>?`
- `arg2`: `JavaList<Node>?`

Returns: `Void`

### `displayAdapterItems`

```norm
Void displayAdapterItems<T>(ListView<T>? arg0, JavaList<T>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `ListView<T>?`
- `arg1`: `JavaList<T>?`

Returns: `Void`

### `displayAdapterRows`

```norm
Void displayAdapterRows<T>(Table<T>? arg0, JavaList<T>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Table<T>?`
- `arg1`: `JavaList<T>?`

Returns: `Void`

### `displayAdapterSegmentedItems`

```norm
Void displayAdapterSegmentedItems<T>(Segmented<T>? arg0, JavaList<T>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Segmented<T>?`
- `arg1`: `JavaList<T>?`

Returns: `Void`

### `displayAdapterSegmentedValue`

```norm
ValueLink<T>? displayAdapterSegmentedValue<T>(Segmented<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Segmented<T>?`

Returns: `ValueLink<T>?`

### `displayAdapterSelected`

```norm
SelectionLink<T>? displayAdapterSelected<T>(ListView<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `ListView<T>?`

Returns: `SelectionLink<T>?`

### `displayAdapterStatistic`

```norm
Statistic? displayAdapterStatistic(String? arg0, Integer arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Integer`

Returns: `Statistic?`

### `displayAdapterStatisticValue`

```norm
Void displayAdapterStatisticValue(Statistic? arg0, Integer arg1)
```

Parameters:

- `arg0`: `Statistic?`
- `arg1`: `Integer`

Returns: `Void`

### `displayAdapterTableColumns`

```norm
Void displayAdapterTableColumns<T>(Table<T>? arg0, JavaList<TableColumnSpec<T>>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Table<T>?`
- `arg1`: `JavaList<TableColumnSpec<T>>?`

Returns: `Void`

### `displayAdapterTableSelected`

```norm
SelectionLink<T>? displayAdapterTableSelected<T>(Table<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Table<T>?`

Returns: `SelectionLink<T>?`

### `displayAdapterTagOnClose`

```norm
Void displayAdapterTagOnClose(Tag? arg0, Function<Void()>? arg1)
```

Parameters:

- `arg0`: `Tag?`
- `arg1`: `Function<Void()>?`

Returns: `Void`

### `displayAdapterTimeline`

```norm
Void displayAdapterTimeline(Timeline? arg0, JavaList<String>? arg1, JavaList<Node>? arg2)
```

Parameters:

- `arg0`: `Timeline?`
- `arg1`: `JavaList<String>?`
- `arg2`: `JavaList<Node>?`

Returns: `Void`

### `displayAdapterTreeChildren`

```norm
Void displayAdapterTreeChildren<T>(Tree<T>? arg0, Function<JavaList<T>?(T?)>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Tree<T>?`
- `arg1`: `Function<JavaList<T>?(T?)>?`

Returns: `Void`

### `displayAdapterTreeSelected`

```norm
TreeSelectionLink<T>? displayAdapterTreeSelected<T>(Tree<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Tree<T>?`

Returns: `TreeSelectionLink<T>?`

## `ui.desktop.kit.internal`

Source: `internal/Divider.norm`

### `Divider`

```norm
class Divider extends Separator implements Skinnable, EventTarget, Styleable
```

#### `Divider`

```norm
Divider(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `setOrientation`

```norm
Void setOrientation(Orientation? arg0)
```

Parameters:

- `arg0`: `Orientation?`

Returns: `Void`

### `dividerNew`

```norm
Divider dividerNew()
```

Returns: `Divider`

### `dividerNew`

```norm
Divider dividerNew(Orientation? arg0)
```

Parameters:

- `arg0`: `Orientation?`

Returns: `Divider`

## `ui.desktop.kit.internal`

Source: `internal/Drawer.norm`

### `Drawer`

```norm
class Drawer implements AutoCloseable
```

#### `Drawer`

```norm
Drawer(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `hide`

```norm
Void hide()
```

Returns: `Void`

#### `isShowing`

```norm
Boolean isShowing()
```

Returns: `Boolean`

#### `show`

```norm
Void show()
```

Returns: `Void`

### `drawerNew`

```norm
Drawer drawerNew(Node? arg0, Node? arg1, Side? arg2)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Node?`
- `arg2`: `Side?`

Returns: `Drawer`

### `drawerNew`

```norm
Drawer drawerNew(Node? arg0, Node? arg1, Side? arg2, ContentOwnership? arg3)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Node?`
- `arg2`: `Side?`
- `arg3`: `ContentOwnership?`

Returns: `Drawer`

## `ui.desktop.kit.internal`

Source: `internal/Dropdown.norm`

### `Dropdown`

```norm
class Dropdown extends Button implements AutoCloseable, Skinnable, EventTarget, Styleable
```

#### `Dropdown`

```norm
Dropdown(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `hide`

```norm
Void hide()
```

Returns: `Void`

#### `isShowing`

```norm
Boolean isShowing()
```

Returns: `Boolean`

#### `show`

```norm
Void show()
```

Returns: `Void`

### `dropdownNew`

```norm
Dropdown dropdownNew(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `Dropdown`

## `ui.desktop.kit.internal`

Source: `internal/DropdownHost.norm`

### `DropdownHost`

```norm
class DropdownHost implements AutoCloseable
```

#### `DropdownHost`

```norm
DropdownHost(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `node`

```norm
Node? node()
```

Returns: `Node?`

#### `title`

```norm
Void title(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/Empty.norm`

### `Empty`

```norm
class Empty extends StackPane implements EventTarget, Styleable
```

#### `Empty`

```norm
Empty(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `setDescription`

```norm
Void setDescription(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `emptyNew`

```norm
Empty emptyNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Empty`

## `ui.desktop.kit.internal`

Source: `internal/FeedbackAdapter.norm`

### `FeedbackAdapter`

```norm
class FeedbackAdapter
```

#### `FeedbackAdapter`

```norm
FeedbackAdapter(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

### `feedbackAdapterActions`

```norm
Void feedbackAdapterActions(Result? arg0, JavaList<Node>? arg1)
```

Parameters:

- `arg0`: `Result?`
- `arg1`: `JavaList<Node>?`

Returns: `Void`

### `feedbackAdapterAffix`

```norm
AffixHost? feedbackAdapterAffix()
```

Returns: `AffixHost?`

### `feedbackAdapterAlert`

```norm
Alert? feedbackAdapterAlert(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Alert?`

### `feedbackAdapterBorderBeam`

```norm
BorderBeam? feedbackAdapterBorderBeam()
```

Returns: `BorderBeam?`

### `feedbackAdapterResult`

```norm
Result? feedbackAdapterResult(String? arg0, String? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `String?`

Returns: `Result?`

### `feedbackAdapterSpin`

```norm
Spin? feedbackAdapterSpin()
```

Returns: `Spin?`

### `feedbackAdapterWatermark`

```norm
Watermark? feedbackAdapterWatermark(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Watermark?`

### `feedbackAdapterWatermarkText`

```norm
Void feedbackAdapterWatermarkText(Watermark? arg0, String? arg1)
```

Parameters:

- `arg0`: `Watermark?`
- `arg1`: `String?`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/FloatButton.norm`

### `FloatButton`

```norm
class FloatButton extends Button implements AutoCloseable, Skinnable, EventTarget, Styleable
```

#### `FloatButton`

```norm
FloatButton(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `attachTo`

```norm
FloatButton? attachTo(StackPane? arg0)
```

Parameters:

- `arg0`: `StackPane?`

Returns: `FloatButton?`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `setOnAction`

```norm
Void setOnAction(Function<Void(ActionEvent?)>? arg0)
```

Parameters:

- `arg0`: `Function<Void(ActionEvent?)>?`

Returns: `Void`

### `floatButtonNew`

```norm
FloatButton floatButtonNew()
```

Returns: `FloatButton`

### `floatButtonNew`

```norm
FloatButton floatButtonNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `FloatButton`

## `ui.desktop.kit.internal`

Source: `internal/FloatButtonGroup.norm`

### `FloatButtonGroup`

```norm
class FloatButtonGroup extends VBox implements EventTarget, Styleable
```

#### `FloatButtonGroup`

```norm
FloatButtonGroup(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `attachTo`

```norm
FloatButtonGroup? attachTo(StackPane? arg0)
```

Parameters:

- `arg0`: `StackPane?`

Returns: `FloatButtonGroup?`

### `floatButtonGroupNew`

```norm
FloatButtonGroup floatButtonGroupNew(JavaFloatButtonArray? arg0)
```

Parameters:

- `arg0`: `JavaFloatButtonArray?`

Returns: `FloatButtonGroup`

## `ui.desktop.kit.internal`

Source: `internal/FloatButtonHost.norm`

### `FloatButtonHost`

```norm
class FloatButtonHost implements AutoCloseable
```

#### `FloatButtonHost`

```norm
FloatButtonHost(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `action`

```norm
Void action(Function<Void()>? arg0)
```

Parameters:

- `arg0`: `Function<Void()>?`

Returns: `Void`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `node`

```norm
StackPane? node()
```

Returns: `StackPane?`

#### `title`

```norm
Void title(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/Handle.norm`

### `Handle`

```norm
interface Handle extends AutoCloseable
```

#### `close`

```norm
Void close()
```

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/Icon.norm`

### `Icon`

```norm
class Icon extends FontIcon implements IconImported1, EventTarget, Styleable
```

#### `Icon`

```norm
Icon(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `setIconLiteral`

```norm
Void setIconLiteral(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setIconSize`

```norm
Void setIconSize(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

### `iconNew`

```norm
Icon iconNew()
```

Returns: `Icon`

### `iconNew`

```norm
Icon iconNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Icon`

## `ui.desktop.kit.internal`

Source: `internal/Image.norm`

### `Image`

```norm
class Image extends StackPane implements EventTarget, Styleable
```

#### `Image`

```norm
Image(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getSource`

```norm
String? getSource()
```

Returns: `String?`

#### `setPreviewable`

```norm
Void setPreviewable(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setSource`

```norm
Void setSource(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `showPreview`

```norm
Modal? showPreview()
```

Returns: `Modal?`

### `imageNew`

```norm
Image imageNew()
```

Returns: `Image`

### `imageNew`

```norm
Image imageNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Image`

### `imageNew`

```norm
Image imageNew(ImageImported1? arg0)
```

Parameters:

- `arg0`: `Image?`

Returns: `Image`

## `ui.desktop.kit.internal`

Source: `internal/IndexLink.norm`

### `IndexLink`

```norm
class IndexLink implements AutoCloseable
```

#### `IndexLink`

```norm
IndexLink(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `unbind`

```norm
Void unbind()
```

Returns: `Void`

#### `update`

```norm
Void update(Integer arg0, Function<Void(Integer?)>? arg1)
```

Parameters:

- `arg0`: `Integer`
- `arg1`: `Function<Void(Integer?)>?`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/Input.norm`

### `Input`

```norm
class Input extends TextField implements Skinnable, EventTarget, Styleable
```

#### `Input`

```norm
Input(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getSelection`

```norm
IndexRange? getSelection()
```

Returns: `IndexRange?`

#### `getText`

```norm
String? getText()
```

Returns: `String?`

#### `getText`

```norm
String? getText(Integer arg0, Integer arg1)
```

Parameters:

- `arg0`: `Integer`
- `arg1`: `Integer`

Returns: `String?`

#### `selectRange`

```norm
Void selectRange(Integer arg0, Integer arg1)
```

Parameters:

- `arg0`: `Integer`
- `arg1`: `Integer`

Returns: `Void`

#### `setPromptText`

```norm
Void setPromptText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `textProperty`

```norm
StringProperty? textProperty()
```

Returns: `StringProperty?`

### `inputNew`

```norm
Input inputNew()
```

Returns: `Input`

### `inputNew`

```norm
Input inputNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Input`

### `inputMultiline`

```norm
TextArea? inputMultiline()
```

Returns: `TextArea?`

### `inputPassword`

```norm
PasswordField? inputPassword()
```

Returns: `PasswordField?`

## `ui.desktop.kit.internal`

Source: `internal/InputAdapter.norm`

### `InputAdapter`

```norm
class InputAdapter
```

#### `InputAdapter`

```norm
InputAdapter(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

### `inputAdapterAutoCompleteValue`

```norm
ValueLink<String>? inputAdapterAutoCompleteValue(AutoComplete? arg0)
```

Parameters:

- `arg0`: `AutoComplete?`

Returns: `ValueLink<String>?`

### `inputAdapterCascaderOptions`

```norm
Void inputAdapterCascaderOptions<T>(Cascader<T>? arg0, JavaList<CascaderItem<T>>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Cascader<T>?`
- `arg1`: `JavaList<CascaderItem<T>>?`

Returns: `Void`

### `inputAdapterCascaderPath`

```norm
SelectionLink<JavaList<T>>? inputAdapterCascaderPath<T>(Cascader<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Cascader<T>?`

Returns: `SelectionLink<JavaList<T>>?`

### `inputAdapterCheckboxValue`

```norm
ValueLink<Boolean>? inputAdapterCheckboxValue(Checkbox? arg0)
```

Parameters:

- `arg0`: `Checkbox?`

Returns: `ValueLink<Boolean>?`

### `inputAdapterColorHex`

```norm
String? inputAdapterColorHex(ColorPicker? arg0)
```

Parameters:

- `arg0`: `ColorPicker?`

Returns: `String?`

### `inputAdapterColorHexValue`

```norm
SelectionLink<String>? inputAdapterColorHexValue(ColorPicker? arg0)
```

Parameters:

- `arg0`: `ColorPicker?`

Returns: `SelectionLink<String>?`

### `inputAdapterDateRangeValue`

```norm
ValueLink<DateRange>? inputAdapterDateRangeValue(DatePickerRange? arg0)
```

Parameters:

- `arg0`: `DatePickerRange?`

Returns: `ValueLink<DateRange>?`

### `inputAdapterDateValue`

```norm
ValueLink<LocalDate>? inputAdapterDateValue(DatePicker? arg0)
```

Parameters:

- `arg0`: `DatePicker?`

Returns: `ValueLink<LocalDate>?`

### `inputAdapterInputSubmit`

```norm
Void inputAdapterInputSubmit(Input? arg0, Function<Void()>? arg1)
```

Parameters:

- `arg0`: `Input?`
- `arg1`: `Function<Void()>?`

Returns: `Void`

### `inputAdapterInputValue`

```norm
ValueLink<String>? inputAdapterInputValue(Input? arg0)
```

Parameters:

- `arg0`: `Input?`

Returns: `ValueLink<String>?`

### `inputAdapterMentionsValue`

```norm
ValueLink<String>? inputAdapterMentionsValue(Mentions? arg0)
```

Parameters:

- `arg0`: `Mentions?`

Returns: `ValueLink<String>?`

### `inputAdapterMultipleOptions`

```norm
Void inputAdapterMultipleOptions<T>(SelectMultiple<T>? arg0, JavaList<T>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `SelectMultiple<T>?`
- `arg1`: `JavaList<T>?`

Returns: `Void`

### `inputAdapterMultipleValue`

```norm
SelectionLink<JavaList<T>>? inputAdapterMultipleValue<T>(SelectMultiple<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `SelectMultiple<T>?`

Returns: `SelectionLink<JavaList<T>>?`

### `inputAdapterNumberValue`

```norm
SelectionLink<BigDecimal>? inputAdapterNumberValue(InputNumber? arg0)
```

Parameters:

- `arg0`: `InputNumber?`

Returns: `SelectionLink<BigDecimal>?`

### `inputAdapterRadioValue`

```norm
ValueLink<Boolean>? inputAdapterRadioValue(Radio? arg0)
```

Parameters:

- `arg0`: `Radio?`

Returns: `ValueLink<Boolean>?`

### `inputAdapterRateValue`

```norm
SelectionLink<Integer>? inputAdapterRateValue(Rate? arg0)
```

Parameters:

- `arg0`: `Rate?`

Returns: `SelectionLink<Integer>?`

### `inputAdapterSearchableOptions`

```norm
Void inputAdapterSearchableOptions<T>(SelectSearchable<T>? arg0, JavaList<T>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `SelectSearchable<T>?`
- `arg1`: `JavaList<T>?`

Returns: `Void`

### `inputAdapterSelect`

```norm
Select<T>? inputAdapterSelect<T>(JavaList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `JavaList<T>?`

Returns: `Select<T>?`

### `inputAdapterSelectMultiple`

```norm
SelectMultiple<T>? inputAdapterSelectMultiple<T>(JavaList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `JavaList<T>?`

Returns: `SelectMultiple<T>?`

### `inputAdapterSelectOptions`

```norm
Void inputAdapterSelectOptions<T>(Select<T>? arg0, JavaList<T>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Select<T>?`
- `arg1`: `JavaList<T>?`

Returns: `Void`

### `inputAdapterSelectSearchable`

```norm
SelectSearchable<T>? inputAdapterSelectSearchable<T>(JavaList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `JavaList<T>?`

Returns: `SelectSearchable<T>?`

### `inputAdapterSelectValue`

```norm
ValueLink<T>? inputAdapterSelectValue<T>(Select<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Select<T>?`

Returns: `ValueLink<T>?`

### `inputAdapterSliderRangeBounds`

```norm
Void inputAdapterSliderRangeBounds(SliderRange? arg0, Double arg1, Double arg2)
```

Parameters:

- `arg0`: `SliderRange?`
- `arg1`: `Double`
- `arg2`: `Double`

Returns: `Void`

### `inputAdapterSliderRangeValue`

```norm
SelectionLink<JavaList<Double>>? inputAdapterSliderRangeValue(SliderRange? arg0)
```

Parameters:

- `arg0`: `SliderRange?`

Returns: `SelectionLink<JavaList<Double>>?`

### `inputAdapterSliderValue`

```norm
SelectionLink<Double>? inputAdapterSliderValue(Slider? arg0)
```

Parameters:

- `arg0`: `Slider?`

Returns: `SelectionLink<Double>?`

### `inputAdapterSwitchValue`

```norm
ValueLink<Boolean>? inputAdapterSwitchValue(Switch? arg0)
```

Parameters:

- `arg0`: `Switch?`

Returns: `ValueLink<Boolean>?`

### `inputAdapterTimeValue`

```norm
ValueLink<LocalTime>? inputAdapterTimeValue(TimePicker? arg0)
```

Parameters:

- `arg0`: `TimePicker?`

Returns: `ValueLink<LocalTime>?`

### `inputAdapterTransferOptions`

```norm
Void inputAdapterTransferOptions<T>(Transfer<T>? arg0, JavaList<T>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Transfer<T>?`
- `arg1`: `JavaList<T>?`

Returns: `Void`

### `inputAdapterTransferValue`

```norm
SelectionLink<JavaList<T>>? inputAdapterTransferValue<T>(Transfer<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Transfer<T>?`

Returns: `SelectionLink<JavaList<T>>?`

### `inputAdapterTreeOptions`

```norm
Void inputAdapterTreeOptions<T>(TreeSelect<T>? arg0, JavaList<CascaderItem<T>>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `TreeSelect<T>?`
- `arg1`: `JavaList<CascaderItem<T>>?`

Returns: `Void`

### `inputAdapterTreeSelect`

```norm
TreeSelect<T>? inputAdapterTreeSelect<T>(JavaList<CascaderItem<T>>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `JavaList<CascaderItem<T>>?`

Returns: `TreeSelect<T>?`

### `inputAdapterTreeSelectValue`

```norm
SelectionLink<T>? inputAdapterTreeSelectValue<T>(TreeSelect<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `TreeSelect<T>?`

Returns: `SelectionLink<T>?`

### `inputAdapterUploadTaskHandler`

```norm
Void inputAdapterUploadTaskHandler(Upload? arg0, Function<CompletableFuture<JavaVoid>?(File?, InputAdapterProgress?)>? arg1)
```

Parameters:

- `arg0`: `Upload?`
- `arg1`: `Function<CompletableFuture<JavaVoid>?(File?, InputAdapterProgress?)>?`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/InputAdapterProgress.norm`

### `InputAdapterProgress`

```norm
interface InputAdapterProgress
```

#### `report`

```norm
Void report(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/InputNumber.norm`

### `InputNumber`

```norm
class InputNumber extends Spinner<BigDecimal> implements Skinnable, EventTarget, Styleable
```

#### `InputNumber`

```norm
InputNumber(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getEditor`

```norm
TextField? getEditor()
```

Returns: `TextField?`

#### `getMaximum`

```norm
BigDecimal? getMaximum()
```

Returns: `BigDecimal?`

#### `getMinimum`

```norm
BigDecimal? getMinimum()
```

Returns: `BigDecimal?`

#### `getStep`

```norm
BigDecimal? getStep()
```

Returns: `BigDecimal?`

#### `getValue`

```norm
BigDecimal? getValue()
```

Returns: `BigDecimal?`

#### `isDraftValid`

```norm
Boolean isDraftValid()
```

Returns: `Boolean`

#### `setScale`

```norm
Void setScale(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

#### `setValue`

```norm
Void setValue(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Void`

#### `setValue`

```norm
Void setValue(BigDecimal? arg0)
```

Parameters:

- `arg0`: `BigDecimal?`

Returns: `Void`

#### `valueProperty`

```norm
ReadOnlyObjectProperty<BigDecimal>? valueProperty()
```

Returns: `ReadOnlyObjectProperty<BigDecimal>?`

### `inputNumberNew`

```norm
InputNumber inputNumberNew()
```

Returns: `InputNumber`

### `inputNumberNew`

```norm
InputNumber inputNumberNew(Double arg0, Double arg1, Double arg2, Double arg3)
```

Parameters:

- `arg0`: `Double`
- `arg1`: `Double`
- `arg2`: `Double`
- `arg3`: `Double`

Returns: `InputNumber`

### `inputNumberNew`

```norm
InputNumber inputNumberNew(BigDecimal? arg0, BigDecimal? arg1, BigDecimal? arg2, BigDecimal? arg3)
```

Parameters:

- `arg0`: `BigDecimal?`
- `arg1`: `BigDecimal?`
- `arg2`: `BigDecimal?`
- `arg3`: `BigDecimal?`

Returns: `InputNumber`

## `ui.desktop.kit.internal`

Source: `internal/KitEnvironment.norm`

### `KitEnvironment`

```norm
class KitEnvironment
```

#### `KitEnvironment`

```norm
KitEnvironment(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

### `kitEnvironmentApply`

```norm
Void kitEnvironmentApply(Node? arg0, String? arg1, Double arg2, Boolean arg3)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `String?`
- `arg2`: `Double`
- `arg3`: `Boolean`

Returns: `Void`

### `kitEnvironmentClear`

```norm
Void kitEnvironmentClear(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/ListView.norm`

### `ListView`

```norm
class ListView<T> extends ListViewImported1<T> implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `ListView`

```norm
ListView(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getItems`

```norm
ObservableList<T>? getItems()
```

Returns: `ObservableList<T>?`

#### `getSelectionModel`

```norm
MultipleSelectionModel<T>? getSelectionModel()
```

Returns: `MultipleSelectionModel<T>?`

### `listViewNew`

```norm
ListView<T> listViewNew<T>()
```

Type parameters:

- `T`

Returns: `ListView<T>`

## `ui.desktop.kit.internal`

Source: `internal/Listy.norm`

### `Listy`

```norm
class Listy<T> extends ListView<T> implements AutoCloseable, Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `Listy`

```norm
Listy(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getItems`

```norm
ObservableList<T>? getItems()
```

Returns: `ObservableList<T>?`

#### `getSelectionModel`

```norm
MultipleSelectionModel<T>? getSelectionModel()
```

Returns: `MultipleSelectionModel<T>?`

#### `rowNodes`

```norm
Void rowNodes(JavaList<Node>? arg0)
```

Parameters:

- `arg0`: `JavaList<Node>?`

Returns: `Void`

#### `rows`

```norm
Void rows(Function<Void(JavaList<T>?)>? arg0)
```

Parameters:

- `arg0`: `Function<Void(JavaList<T>?)>?`

Returns: `Void`

#### `setRowHeight`

```norm
Void setRowHeight(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Void`

### `listyNew`

```norm
Listy<T> listyNew<T>()
```

Type parameters:

- `T`

Returns: `Listy<T>`

## `ui.desktop.kit.internal`

Source: `internal/Mentions.norm`

### `Mentions`

```norm
class Mentions extends TextArea implements Skinnable, EventTarget, Styleable
```

#### `Mentions`

```norm
Mentions(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getSuggestions`

```norm
ObservableList<String>? getSuggestions()
```

Returns: `ObservableList<String>?`

#### `getText`

```norm
String? getText()
```

Returns: `String?`

#### `getText`

```norm
String? getText(Integer arg0, Integer arg1)
```

Parameters:

- `arg0`: `Integer`
- `arg1`: `Integer`

Returns: `String?`

#### `insertMention`

```norm
Void insertMention(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setPromptText`

```norm
Void setPromptText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setSuggestions`

```norm
Void setSuggestions(JavaList<String>? arg0)
```

Parameters:

- `arg0`: `JavaList<String>?`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `textProperty`

```norm
StringProperty? textProperty()
```

Returns: `StringProperty?`

### `mentionsNew`

```norm
Mentions mentionsNew()
```

Returns: `Mentions`

## `ui.desktop.kit.internal`

Source: `internal/Menu.norm`

### `Menu`

```norm
class Menu extends MenuBar implements Skinnable, EventTarget, Styleable
```

#### `Menu`

```norm
Menu(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `add`

```norm
MenuImported1? add(String? arg0, JavaMenuItemArray? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `JavaMenuItemArray?`

Returns: `Menu?`

#### `getMenus`

```norm
ObservableList<MenuImported1>? getMenus()
```

Returns: `ObservableList<Menu>?`

### `menuNew`

```norm
Menu menuNew()
```

Returns: `Menu`

## `ui.desktop.kit.internal`

Source: `internal/Message.norm`

### `Message`

```norm
class Message
```

#### `Message`

```norm
Message(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getVisibleCount`

```norm
Integer getVisibleCount()
```

Returns: `Integer`

#### `show`

```norm
Handle? show(String? arg0, Duration? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Duration?`

Returns: `Handle?`

#### `show`

```norm
Handle? show(String? arg0, Duration? arg1, Function<Void()>? arg2)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Duration?`
- `arg2`: `Function<Void()>?`

Returns: `Handle?`

#### `success`

```norm
Handle? success(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Handle?`

## `ui.desktop.kit.internal`

Source: `internal/Modal.norm`

### `Modal`

```norm
class Modal implements AutoCloseable
```

#### `Modal`

```norm
Modal(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `hide`

```norm
Void hide()
```

Returns: `Void`

#### `isShowing`

```norm
Boolean isShowing()
```

Returns: `Boolean`

#### `show`

```norm
Void show()
```

Returns: `Void`

### `modalNew`

```norm
Modal modalNew(Node? arg0, String? arg1, Node? arg2)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `String?`
- `arg2`: `Node?`

Returns: `Modal`

### `modalNew`

```norm
Modal modalNew(Node? arg0, String? arg1, Node? arg2, ContentOwnership? arg3)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `String?`
- `arg2`: `Node?`
- `arg3`: `ContentOwnership?`

Returns: `Modal`

## `ui.desktop.kit.internal`

Source: `internal/NavigationLayoutAdapter.norm`

### `NavigationLayoutAdapter`

```norm
class NavigationLayoutAdapter
```

#### `NavigationLayoutAdapter`

```norm
NavigationLayoutAdapter(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

### `navigationLayoutAdapterAnchor`

```norm
Void navigationLayoutAdapterAnchor(AnchorHost? arg0, JavaList<String>? arg1, JavaList<Node>? arg2)
```

Parameters:

- `arg0`: `AnchorHost?`
- `arg1`: `JavaList<String>?`
- `arg2`: `JavaList<Node>?`

Returns: `Void`

### `navigationLayoutAdapterAnchorHost`

```norm
AnchorHost? navigationLayoutAdapterAnchorHost()
```

Returns: `AnchorHost?`

### `navigationLayoutAdapterAnchorSelection`

```norm
IndexLink? navigationLayoutAdapterAnchorSelection(AnchorHost? arg0)
```

Parameters:

- `arg0`: `AnchorHost?`

Returns: `IndexLink?`

### `navigationLayoutAdapterBreadcrumb`

```norm
Void navigationLayoutAdapterBreadcrumb(Breadcrumb? arg0, JavaList<String>? arg1, Function<Void(Integer?)>? arg2)
```

Parameters:

- `arg0`: `Breadcrumb?`
- `arg1`: `JavaList<String>?`
- `arg2`: `Function<Void(Integer?)>?`

Returns: `Void`

### `navigationLayoutAdapterButtonAction`

```norm
Void navigationLayoutAdapterButtonAction(Button? arg0, Function<Void()>? arg1)
```

Parameters:

- `arg0`: `Button?`
- `arg1`: `Function<Void()>?`

Returns: `Void`

### `navigationLayoutAdapterClearMenu`

```norm
Void navigationLayoutAdapterClearMenu(Menu? arg0)
```

Parameters:

- `arg0`: `Menu?`

Returns: `Void`

### `navigationLayoutAdapterCreateSteps`

```norm
Steps? navigationLayoutAdapterCreateSteps()
```

Returns: `Steps?`

### `navigationLayoutAdapterDropdown`

```norm
DropdownHost? navigationLayoutAdapterDropdown(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `DropdownHost?`

### `navigationLayoutAdapterDropdownContent`

```norm
Void navigationLayoutAdapterDropdownContent(DropdownHost? arg0, Node? arg1)
```

Parameters:

- `arg0`: `DropdownHost?`
- `arg1`: `Node?`

Returns: `Void`

### `navigationLayoutAdapterFloatButton`

```norm
FloatButtonHost? navigationLayoutAdapterFloatButton(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `FloatButtonHost?`

### `navigationLayoutAdapterFloatButtonContent`

```norm
Void navigationLayoutAdapterFloatButtonContent(FloatButtonHost? arg0, Node? arg1)
```

Parameters:

- `arg0`: `FloatButtonHost?`
- `arg1`: `Node?`

Returns: `Void`

### `navigationLayoutAdapterMenuGroup`

```norm
Void navigationLayoutAdapterMenuGroup(Menu? arg0, String? arg1, JavaList<String>? arg2, Function<Void(Integer?)>? arg3)
```

Parameters:

- `arg0`: `Menu?`
- `arg1`: `String?`
- `arg2`: `JavaList<String>?`
- `arg3`: `Function<Void(Integer?)>?`

Returns: `Void`

### `navigationLayoutAdapterPaginationSelection`

```norm
IndexLink? navigationLayoutAdapterPaginationSelection(Pagination? arg0)
```

Parameters:

- `arg0`: `Pagination?`

Returns: `IndexLink?`

### `navigationLayoutAdapterSplitter`

```norm
Splitter? navigationLayoutAdapterSplitter()
```

Returns: `Splitter?`

### `navigationLayoutAdapterSplitter`

```norm
Void navigationLayoutAdapterSplitter(Splitter? arg0, JavaList<Node>? arg1, Double arg2)
```

Parameters:

- `arg0`: `Splitter?`
- `arg1`: `JavaList<Node>?`
- `arg2`: `Double`

Returns: `Void`

### `navigationLayoutAdapterSteps`

```norm
Void navigationLayoutAdapterSteps(Steps? arg0, JavaList<String>? arg1)
```

Parameters:

- `arg0`: `Steps?`
- `arg1`: `JavaList<String>?`

Returns: `Void`

### `navigationLayoutAdapterStepsSelection`

```norm
IndexLink? navigationLayoutAdapterStepsSelection(Steps? arg0)
```

Parameters:

- `arg0`: `Steps?`

Returns: `IndexLink?`

### `navigationLayoutAdapterTabs`

```norm
Void navigationLayoutAdapterTabs(Tabs? arg0, JavaList<String>? arg1, JavaList<Node>? arg2)
```

Parameters:

- `arg0`: `Tabs?`
- `arg1`: `JavaList<String>?`
- `arg2`: `JavaList<Node>?`

Returns: `Void`

### `navigationLayoutAdapterTabsSelection`

```norm
IndexLink? navigationLayoutAdapterTabsSelection(Tabs? arg0)
```

Parameters:

- `arg0`: `Tabs?`

Returns: `IndexLink?`

## `ui.desktop.kit.internal`

Source: `internal/NoticeHost.norm`

### `NoticeHost`

```norm
class NoticeHost extends Region implements AutoCloseable, EventTarget, Styleable
```

#### `NoticeHost`

```norm
NoticeHost(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `content`

```norm
Void content(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

#### `dismiss`

```norm
Void dismiss()
```

Returns: `Void`

#### `update`

```norm
Void update(String? arg0, Double arg1, Boolean arg2, Function<Void()>? arg3)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Double`
- `arg2`: `Boolean`
- `arg3`: `Function<Void()>?`

Returns: `Void`

### `noticeHostMessage`

```norm
NoticeHost? noticeHostMessage()
```

Returns: `NoticeHost?`

### `noticeHostNotification`

```norm
NoticeHost? noticeHostNotification()
```

Returns: `NoticeHost?`

## `ui.desktop.kit.internal`

Source: `internal/Notification.norm`

### `Notification`

```norm
class Notification
```

#### `Notification`

```norm
Notification(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `show`

```norm
Handle? show(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `Handle?`

#### `show`

```norm
Handle? show(String? arg0, Node? arg1, Function<Void()>? arg2)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`
- `arg2`: `Function<Void()>?`

Returns: `Handle?`

## `ui.desktop.kit.internal`

Source: `internal/OverlayAdapter.norm`

### `OverlayAdapter`

```norm
class OverlayAdapter extends StackPane implements AutoCloseable, EventTarget, Styleable
```

#### `OverlayAdapter`

```norm
OverlayAdapter(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `contentNode`

```norm
Node? contentNode()
```

Returns: `Node?`

#### `dismiss`

```norm
Void dismiss()
```

Returns: `Void`

#### `isShowing`

```norm
Boolean isShowing()
```

Returns: `Boolean`

#### `setConfirmed`

```norm
Void setConfirmed(Function<Void()>? arg0)
```

Parameters:

- `arg0`: `Function<Void()>?`

Returns: `Void`

#### `setContent`

```norm
Void setContent(Node? arg0, Node? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Node?`

Returns: `Void`

#### `setOpen`

```norm
Void setOpen(Boolean arg0, Function<Void()>? arg1)
```

Parameters:

- `arg0`: `Boolean`
- `arg1`: `Function<Void()>?`

Returns: `Void`

#### `setSide`

```norm
Void setSide(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setTourSteps`

```norm
Void setTourSteps(JavaList<String>? arg0, JavaList<String>? arg1, JavaList<Node>? arg2)
```

Parameters:

- `arg0`: `JavaList<String>?`
- `arg1`: `JavaList<String>?`
- `arg2`: `JavaList<Node>?`

Returns: `Void`

#### `unbindOpen`

```norm
Void unbindOpen()
```

Returns: `Void`

### `overlayAdapterDrawer`

```norm
OverlayAdapter? overlayAdapterDrawer(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `OverlayAdapter?`

### `overlayAdapterModal`

```norm
OverlayAdapter? overlayAdapterModal(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `OverlayAdapter?`

### `overlayAdapterPopconfirm`

```norm
OverlayAdapter? overlayAdapterPopconfirm(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `OverlayAdapter?`

### `overlayAdapterPopover`

```norm
OverlayAdapter? overlayAdapterPopover()
```

Returns: `OverlayAdapter?`

### `overlayAdapterTooltip`

```norm
OverlayAdapter? overlayAdapterTooltip(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `OverlayAdapter?`

### `overlayAdapterTour`

```norm
OverlayAdapter? overlayAdapterTour()
```

Returns: `OverlayAdapter?`

## `ui.desktop.kit.internal`

Source: `internal/OverlayHost.norm`

### `OverlayHost`

```norm
interface OverlayHost
```

### `overlayHostWrap`

```norm
OverlayHost_Layer? overlayHostWrap(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `OverlayHost_Layer?`

## `ui.desktop.kit.internal`

Source: `internal/Pagination.norm`

### `Pagination`

```norm
class Pagination extends HBox implements EventTarget, Styleable
```

#### `Pagination`

```norm
Pagination(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getCurrentPage`

```norm
Integer getCurrentPage()
```

Returns: `Integer`

#### `getPageCount`

```norm
Integer getPageCount()
```

Returns: `Integer`

#### `next`

```norm
Void next()
```

Returns: `Void`

#### `previous`

```norm
Void previous()
```

Returns: `Void`

#### `setCurrentPage`

```norm
Void setCurrentPage(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

#### `setPageSize`

```norm
Void setPageSize(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

#### `setTotalItems`

```norm
Void setTotalItems(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

### `paginationNew`

```norm
Pagination paginationNew(Integer arg0, Integer arg1)
```

Parameters:

- `arg0`: `Integer`
- `arg1`: `Integer`

Returns: `Pagination`

## `ui.desktop.kit.internal`

Source: `internal/Popconfirm.norm`

### `Popconfirm`

```norm
class Popconfirm implements AutoCloseable
```

#### `Popconfirm`

```norm
Popconfirm(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `hide`

```norm
Void hide()
```

Returns: `Void`

#### `show`

```norm
Void show()
```

Returns: `Void`

### `popconfirmNew`

```norm
Popconfirm popconfirmNew(Node? arg0, String? arg1, Function<Void()>? arg2)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `String?`
- `arg2`: `Function<Void()>?`

Returns: `Popconfirm`

## `ui.desktop.kit.internal`

Source: `internal/Popover.norm`

### `Popover`

```norm
class Popover implements AutoCloseable
```

#### `Popover`

```norm
Popover(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `hide`

```norm
Void hide()
```

Returns: `Void`

#### `isShowing`

```norm
Boolean isShowing()
```

Returns: `Boolean`

#### `show`

```norm
Void show()
```

Returns: `Void`

### `popoverNew`

```norm
Popover popoverNew(Node? arg0, Node? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Node?`

Returns: `Popover`

### `popoverNew`

```norm
Popover popoverNew(Node? arg0, Node? arg1, ContentOwnership? arg2)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Node?`
- `arg2`: `ContentOwnership?`

Returns: `Popover`

## `ui.desktop.kit.internal`

Source: `internal/Progress.norm`

### `Progress`

```norm
class Progress extends ProgressBar implements Skinnable, EventTarget, Styleable
```

#### `Progress`

```norm
Progress(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getProgress`

```norm
Double getProgress()
```

Returns: `Double`

#### `setFraction`

```norm
Void setFraction(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Void`

#### `setProgress`

```norm
Void setProgress(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Void`

#### `setWork`

```norm
Void setWork(Integer arg0, Integer arg1)
```

Parameters:

- `arg0`: `Integer`
- `arg1`: `Integer`

Returns: `Void`

### `progressNew`

```norm
Progress progressNew()
```

Returns: `Progress`

### `progressNew`

```norm
Progress progressNew(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Progress`

## `ui.desktop.kit.internal`

Source: `internal/QRCode.norm`

### `QRCode`

```norm
class QRCode extends ImageView implements EventTarget, Styleable
```

#### `QRCode`

```norm
QRCode(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getText`

```norm
String? getText()
```

Returns: `String?`

#### `setSize`

```norm
Void setSize(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `qrCodeNew`

```norm
QRCode qrCodeNew(String? arg0, Integer arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Integer`

Returns: `QRCode`

## `ui.desktop.kit.internal`

Source: `internal/Radio.norm`

### `Radio`

```norm
class Radio extends RadioButton implements Toggle, Skinnable, EventTarget, Styleable
```

#### `Radio`

```norm
Radio(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `isSelected`

```norm
Boolean isSelected()
```

Returns: `Boolean`

#### `selectedProperty`

```norm
BooleanProperty? selectedProperty()
```

Returns: `BooleanProperty?`

#### `setSelected`

```norm
Void setSelected(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setToggleGroup`

```norm
Void setToggleGroup(ToggleGroup? arg0)
```

Parameters:

- `arg0`: `ToggleGroup?`

Returns: `Void`

### `radioNew`

```norm
Radio radioNew()
```

Returns: `Radio`

### `radioNew`

```norm
Radio radioNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Radio`

## `ui.desktop.kit.internal`

Source: `internal/Rate.norm`

### `Rate`

```norm
class Rate extends HBox implements EventTarget, Styleable
```

#### `Rate`

```norm
Rate(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getValue`

```norm
Integer getValue()
```

Returns: `Integer`

#### `setValue`

```norm
Void setValue(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

#### `valueProperty`

```norm
IntegerProperty? valueProperty()
```

Returns: `IntegerProperty?`

### `rateNew`

```norm
Rate rateNew()
```

Returns: `Rate`

### `rateNew`

```norm
Rate rateNew(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Rate`

## `ui.desktop.kit.internal`

Source: `internal/Result.norm`

### `Result`

```norm
class Result extends VBox implements EventTarget, Styleable
```

#### `Result`

```norm
Result(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `setActions`

```norm
Void setActions(JavaList<Node>? arg0)
```

Parameters:

- `arg0`: `JavaList<Node>?`

Returns: `Void`

#### `setDescription`

```norm
Void setDescription(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

#### `setTitle`

```norm
Void setTitle(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `resultNew`

```norm
Result resultNew(String? arg0, String? arg1, JavaNodeArray? arg2)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `String?`
- `arg2`: `JavaNodeArray?`

Returns: `Result`

## `ui.desktop.kit.internal`

Source: `internal/Segmented.norm`

### `Segmented`

```norm
class Segmented<T> extends HBox implements EventTarget, Styleable
```

Type parameters:

- `T`

#### `Segmented`

```norm
Segmented(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getItems`

```norm
ObservableList<T>? getItems()
```

Returns: `ObservableList<T>?`

#### `getValue`

```norm
T? getValue()
```

Returns: `T?`

#### `setValue`

```norm
Void setValue(T? arg0)
```

Parameters:

- `arg0`: `T?`

Returns: `Void`

### `segmentedNew`

```norm
Segmented<T> segmentedNew<T>(JavaList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `JavaList<T>?`

Returns: `Segmented<T>`

## `ui.desktop.kit.internal`

Source: `internal/Select.norm`

### `Select`

```norm
class Select<T> extends ComboBox<T> implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `Select`

```norm
Select(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getItems`

```norm
ObservableList<T>? getItems()
```

Returns: `ObservableList<T>?`

#### `getValue`

```norm
T? getValue()
```

Returns: `T?`

#### `setValue`

```norm
Void setValue(T? arg0)
```

Parameters:

- `arg0`: `T?`

Returns: `Void`

#### `valueProperty`

```norm
ObjectProperty<T>? valueProperty()
```

Returns: `ObjectProperty<T>?`

### `selectNew`

```norm
Select<T> selectNew<T>()
```

Type parameters:

- `T`

Returns: `Select<T>`

### `selectNew`

```norm
Select<T> selectNew<T>(ObservableList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `ObservableList<T>?`

Returns: `Select<T>`

### `selectMultiple`

```norm
SelectMultiple<T>? selectMultiple<T>(ObservableList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `ObservableList<T>?`

Returns: `SelectMultiple<T>?`

### `selectSearchable`

```norm
SelectSearchable<T>? selectSearchable<T>(ObservableList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `ObservableList<T>?`

Returns: `SelectSearchable<T>?`

## `ui.desktop.kit.internal`

Source: `internal/SelectMultiple.norm`

### `SelectMultiple`

```norm
class SelectMultiple<T> extends HBox implements EventTarget, Styleable
```

Type parameters:

- `T`

#### `SelectMultiple`

```norm
SelectMultiple(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `deselect`

```norm
Void deselect(T? arg0)
```

Parameters:

- `arg0`: `T?`

Returns: `Void`

#### `getOptions`

```norm
ObservableList<T>? getOptions()
```

Returns: `ObservableList<T>?`

#### `getSearchField`

```norm
TextField? getSearchField()
```

Returns: `TextField?`

#### `getSelectedItems`

```norm
ObservableList<T>? getSelectedItems()
```

Returns: `ObservableList<T>?`

#### `select`

```norm
Void select(T? arg0)
```

Parameters:

- `arg0`: `T?`

Returns: `Void`

### `selectMultipleNew`

```norm
SelectMultiple<T> selectMultipleNew<T>(ObservableList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `ObservableList<T>?`

Returns: `SelectMultiple<T>`

## `ui.desktop.kit.internal`

Source: `internal/SelectSearchable.norm`

### `SelectSearchable`

```norm
class SelectSearchable<T> extends VBox implements EventTarget, Styleable
```

Type parameters:

- `T`

#### `SelectSearchable`

```norm
SelectSearchable(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getOptions`

```norm
ObservableList<T>? getOptions()
```

Returns: `ObservableList<T>?`

#### `getSearchField`

```norm
TextField? getSearchField()
```

Returns: `TextField?`

#### `getSelect`

```norm
Select<T>? getSelect()
```

Returns: `Select<T>?`

### `selectSearchableNew`

```norm
SelectSearchable<T> selectSearchableNew<T>(ObservableList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `ObservableList<T>?`

Returns: `SelectSearchable<T>`

## `ui.desktop.kit.internal`

Source: `internal/SelectionLink.norm`

### `SelectionLink`

```norm
class SelectionLink<T> implements AutoCloseable
```

Type parameters:

- `T`

#### `SelectionLink`

```norm
SelectionLink(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `node`

```norm
Node? node()
```

Returns: `Node?`

#### `unbind`

```norm
Void unbind()
```

Returns: `Void`

#### `update`

```norm
Void update(T? arg0, Function<Void(T?)>? arg1)
```

Parameters:

- `arg0`: `T?`
- `arg1`: `Function<Void(T?)>?`

Returns: `Void`

### `selectionLinkNew`

```norm
SelectionLink<T> selectionLinkNew<T>(Node? arg0, ObservableValue<T>? arg1, Function<Void(T?)>? arg2)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Node?`
- `arg1`: `ObservableValue<T>?`
- `arg2`: `Function<Void(T?)>?`

Returns: `SelectionLink<T>`

### `selectionLinkNew`

```norm
SelectionLink<T> selectionLinkNew<T>(Node? arg0, ObservableValue<T>? arg1, Function<Void(T?)>? arg2, Function<Void()>? arg3)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Node?`
- `arg1`: `ObservableValue<T>?`
- `arg2`: `Function<Void(T?)>?`
- `arg3`: `Function<Void()>?`

Returns: `SelectionLink<T>`

## `ui.desktop.kit.internal`

Source: `internal/Skeleton.norm`

### `Skeleton`

```norm
class Skeleton extends VBox implements EventTarget, Styleable
```

#### `Skeleton`

```norm
Skeleton(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `setLines`

```norm
Void setLines(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

### `skeletonNew`

```norm
Skeleton skeletonNew(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Skeleton`

## `ui.desktop.kit.internal`

Source: `internal/Slider.norm`

### `Slider`

```norm
class Slider extends SliderImported1 implements Skinnable, EventTarget, Styleable
```

#### `Slider`

```norm
Slider(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getValue`

```norm
Double getValue()
```

Returns: `Double`

#### `setMax`

```norm
Void setMax(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Void`

#### `setMin`

```norm
Void setMin(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Void`

#### `setShowTickLabels`

```norm
Void setShowTickLabels(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setShowTickMarks`

```norm
Void setShowTickMarks(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setValue`

```norm
Void setValue(Double arg0)
```

Parameters:

- `arg0`: `Double`

Returns: `Void`

#### `valueProperty`

```norm
DoubleProperty? valueProperty()
```

Returns: `DoubleProperty?`

### `sliderNew`

```norm
Slider sliderNew()
```

Returns: `Slider`

### `sliderNew`

```norm
Slider sliderNew(Double arg0, Double arg1, Double arg2)
```

Parameters:

- `arg0`: `Double`
- `arg1`: `Double`
- `arg2`: `Double`

Returns: `Slider`

## `ui.desktop.kit.internal`

Source: `internal/SliderRange.norm`

### `SliderRange`

```norm
class SliderRange extends HBox implements EventTarget, Styleable
```

#### `SliderRange`

```norm
SliderRange(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getEnd`

```norm
Double getEnd()
```

Returns: `Double`

#### `getStart`

```norm
Double getStart()
```

Returns: `Double`

#### `setRange`

```norm
Void setRange(Double arg0, Double arg1)
```

Parameters:

- `arg0`: `Double`
- `arg1`: `Double`

Returns: `Void`

### `sliderRangeNew`

```norm
SliderRange sliderRangeNew(Double arg0, Double arg1, Double arg2, Double arg3)
```

Parameters:

- `arg0`: `Double`
- `arg1`: `Double`
- `arg2`: `Double`
- `arg3`: `Double`

Returns: `SliderRange`

## `ui.desktop.kit.internal`

Source: `internal/Spin.norm`

### `Spin`

```norm
class Spin extends StackPane implements EventTarget, Styleable
```

#### `Spin`

```norm
Spin(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `isSpinning`

```norm
Boolean isSpinning()
```

Returns: `Boolean`

#### `setContent`

```norm
Void setContent(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

#### `setSpinning`

```norm
Void setSpinning(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

### `spinNew`

```norm
Spin spinNew(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Spin`

## `ui.desktop.kit.internal`

Source: `internal/Splitter.norm`

### `Splitter`

```norm
class Splitter extends SplitPane implements Skinnable, EventTarget, Styleable
```

#### `Splitter`

```norm
Splitter(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getItems`

```norm
ObservableList<Node>? getItems()
```

Returns: `ObservableList<Node>?`

#### `setDividerPosition`

```norm
Void setDividerPosition(Integer arg0, Double arg1)
```

Parameters:

- `arg0`: `Integer`
- `arg1`: `Double`

Returns: `Void`

#### `setOrientation`

```norm
Void setOrientation(Orientation? arg0)
```

Parameters:

- `arg0`: `Orientation?`

Returns: `Void`

### `splitterNew`

```norm
Splitter splitterNew(JavaNodeArray? arg0)
```

Parameters:

- `arg0`: `JavaNodeArray?`

Returns: `Splitter`

## `ui.desktop.kit.internal`

Source: `internal/Statistic.norm`

### `Statistic`

```norm
class Statistic extends VBox implements AutoCloseable, EventTarget, Styleable
```

#### `Statistic`

```norm
Statistic(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getValue`

```norm
Number? getValue()
```

Returns: `Number?`

#### `setValue`

```norm
Void setValue(Number? arg0)
```

Parameters:

- `arg0`: `Number?`

Returns: `Void`

### `statisticNew`

```norm
Statistic statisticNew(String? arg0, Number? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Number?`

Returns: `Statistic`

## `ui.desktop.kit.internal`

Source: `internal/Steps.norm`

### `Steps`

```norm
class Steps extends HBox implements EventTarget, Styleable
```

#### `Steps`

```norm
Steps(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getCurrentStep`

```norm
Integer getCurrentStep()
```

Returns: `Integer`

#### `getSteps`

```norm
ObservableList<String>? getSteps()
```

Returns: `ObservableList<String>?`

#### `setCurrentStep`

```norm
Void setCurrentStep(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

### `stepsNew`

```norm
Steps stepsNew(JavaStringArray? arg0)
```

Parameters:

- `arg0`: `JavaStringArray?`

Returns: `Steps`

## `ui.desktop.kit.internal`

Source: `internal/Switch.norm`

### `Switch`

```norm
class Switch extends ToggleButton implements AutoCloseable, Toggle, Skinnable, EventTarget, Styleable
```

#### `Switch`

```norm
Switch(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `fire`

```norm
Void fire()
```

Returns: `Void`

#### `isSelected`

```norm
Boolean isSelected()
```

Returns: `Boolean`

#### `selectedProperty`

```norm
BooleanProperty? selectedProperty()
```

Returns: `BooleanProperty?`

#### `setSelected`

```norm
Void setSelected(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `switchNew`

```norm
Switch switchNew()
```

Returns: `Switch`

### `switchNew`

```norm
Switch switchNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Switch`

## `ui.desktop.kit.internal`

Source: `internal/Table.norm`

### `Table`

```norm
class Table<T> extends TableView<T> implements AutoCloseable, Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `Table`

```norm
Table(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `cellNodes`

```norm
Void cellNodes(JavaList<Node>? arg0)
```

Parameters:

- `arg0`: `JavaList<Node>?`

Returns: `Void`

#### `cellSlots`

```norm
Void cellSlots(Function<Void(JavaList<TableCellSlot<T>>?)>? arg0)
```

Parameters:

- `arg0`: `Function<Void(JavaList<TableCellSlot<T>>?)>?`

Returns: `Void`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `column`

```norm
TableColumn<T, V>? column<V>(String? arg0, Function<V?(T?)>? arg1)
```

Type parameters:

- `V`

Parameters:

- `arg0`: `String?`
- `arg1`: `Function<V?(T?)>?`

Returns: `TableColumn<T, V>?`

#### `editableColumn`

```norm
TableColumn<T, String>? editableColumn(String? arg0, Function<ObservableValue<String>?(T?)>? arg1, Function<Void(T?, String?)>? arg2)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Function<ObservableValue<String>?(T?)>?`
- `arg2`: `Function<Void(T?, String?)>?`

Returns: `TableColumn<T, String>?`

#### `getColumns`

```norm
ObservableList<TableColumn<T, ?>>? getColumns()
```

Returns: `ObservableList<TableColumn<T, ?>>?`

#### `getItems`

```norm
ObservableList<T>? getItems()
```

Returns: `ObservableList<T>?`

#### `getSource`

```norm
ObservableList<T>? getSource()
```

Returns: `ObservableList<T>?`

#### `observableColumn`

```norm
TableColumn<T, V>? observableColumn<V>(String? arg0, Function<ObservableValue<V>?(T?)>? arg1)
```

Type parameters:

- `V`

Parameters:

- `arg0`: `String?`
- `arg1`: `Function<ObservableValue<V>?(T?)>?`

Returns: `TableColumn<T, V>?`

#### `setPredicate`

```norm
Void setPredicate(Function<Boolean(T?)>? arg0)
```

Parameters:

- `arg0`: `Function<Boolean(T?)>?`

Returns: `Void`

#### `setSource`

```norm
Void setSource(ObservableList<T>? arg0)
```

Parameters:

- `arg0`: `ObservableList<T>?`

Returns: `Void`

### `tableNew`

```norm
Table<T> tableNew<T>()
```

Type parameters:

- `T`

Returns: `Table<T>`

## `ui.desktop.kit.internal`

Source: `internal/TableCellSlot.norm`

### `TableCellSlot`

```norm
class TableCellSlot<T> extends Record
```

Type parameters:

- `T`

#### `TableCellSlot`

```norm
TableCellSlot(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `columnId`

```norm
String? columnId()
```

Returns: `String?`

#### `index`

```norm
Integer index()
```

Returns: `Integer`

#### `row`

```norm
T? row()
```

Returns: `T?`

## `ui.desktop.kit.internal`

Source: `internal/TableColumnSpec.norm`

### `TableColumnSpec`

```norm
class TableColumnSpec<T> extends Record
```

Type parameters:

- `T`

#### `TableColumnSpec`

```norm
TableColumnSpec(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

### `tableColumnSpecNew`

```norm
TableColumnSpec<T> tableColumnSpecNew<T>(String? arg0, String? arg1, Function<String?(T?)>? arg2, Function<Integer(T?, T?)>? arg3, Boolean arg4)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `String?`
- `arg1`: `String?`
- `arg2`: `Function<String?(T?)>?`
- `arg3`: `Function<Integer(T?, T?)>?`
- `arg4`: `Boolean`

Returns: `TableColumnSpec<T>`

## `ui.desktop.kit.internal`

Source: `internal/TableSortLink.norm`

### `TableSortLink`

```norm
class TableSortLink<T> implements AutoCloseable
```

Type parameters:

- `T`

#### `TableSortLink`

```norm
TableSortLink(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `columns`

```norm
Void columns(JavaList<TableColumnSpec<T>>? arg0)
```

Parameters:

- `arg0`: `JavaList<TableColumnSpec<T>>?`

Returns: `Void`

#### `unbind`

```norm
Void unbind()
```

Returns: `Void`

#### `update`

```norm
Void update(TableSortState? arg0, Function<Void(TableSortState?)>? arg1)
```

Parameters:

- `arg0`: `TableSortState?`
- `arg1`: `Function<Void(TableSortState?)>?`

Returns: `Void`

### `tableSortLinkNew`

```norm
TableSortLink<T> tableSortLinkNew<T>(Table<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Table<T>?`

Returns: `TableSortLink<T>`

## `ui.desktop.kit.internal`

Source: `internal/TableSortState.norm`

### `TableSortState`

```norm
class TableSortState extends Record
```

#### `TableSortState`

```norm
TableSortState(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `columnId`

```norm
String? columnId()
```

Returns: `String?`

#### `descending`

```norm
Boolean descending()
```

Returns: `Boolean`

### `tableSortStateNew`

```norm
TableSortState tableSortStateNew(String? arg0, Boolean arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Boolean`

Returns: `TableSortState`

## `ui.desktop.kit.internal`

Source: `internal/Tabs.norm`

### `Tabs`

```norm
class Tabs extends TabPane implements Skinnable, EventTarget, Styleable
```

#### `Tabs`

```norm
Tabs(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `add`

```norm
Tab? add(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `Tab?`

#### `getTabs`

```norm
ObservableList<Tab>? getTabs()
```

Returns: `ObservableList<Tab>?`

### `tabsNew`

```norm
Tabs tabsNew()
```

Returns: `Tabs`

## `ui.desktop.kit.internal`

Source: `internal/Tag.norm`

### `Tag`

```norm
class Tag extends HBox implements EventTarget, Styleable
```

#### `Tag`

```norm
Tag(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getText`

```norm
String? getText()
```

Returns: `String?`

#### `setClosable`

```norm
Void setClosable(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `tagNew`

```norm
Tag tagNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Tag`

## `ui.desktop.kit.internal`

Source: `internal/TimePicker.norm`

### `TimePicker`

```norm
class TimePicker extends ComboBox<LocalTime> implements Skinnable, EventTarget, Styleable
```

#### `TimePicker`

```norm
TimePicker(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getEarliest`

```norm
LocalTime? getEarliest()
```

Returns: `LocalTime?`

#### `getLatest`

```norm
LocalTime? getLatest()
```

Returns: `LocalTime?`

#### `getMinuteStep`

```norm
Integer getMinuteStep()
```

Returns: `Integer`

#### `getValue`

```norm
LocalTime? getValue()
```

Returns: `LocalTime?`

#### `setAllowedRange`

```norm
Void setAllowedRange(LocalTime? arg0, LocalTime? arg1)
```

Parameters:

- `arg0`: `LocalTime?`
- `arg1`: `LocalTime?`

Returns: `Void`

#### `setMinuteStep`

```norm
Void setMinuteStep(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `Void`

#### `setValue`

```norm
Void setValue(LocalTime? arg0)
```

Parameters:

- `arg0`: `LocalTime?`

Returns: `Void`

#### `valueProperty`

```norm
ObjectProperty<LocalTime>? valueProperty()
```

Returns: `ObjectProperty<LocalTime>?`

### `timePickerNew`

```norm
TimePicker timePickerNew()
```

Returns: `TimePicker`

### `timePickerNew`

```norm
TimePicker timePickerNew(Integer arg0)
```

Parameters:

- `arg0`: `Integer`

Returns: `TimePicker`

## `ui.desktop.kit.internal`

Source: `internal/Timeline.norm`

### `Timeline`

```norm
class Timeline extends VBox implements EventTarget, Styleable
```

#### `Timeline`

```norm
Timeline(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `add`

```norm
Void add(String? arg0, Node? arg1)
```

Parameters:

- `arg0`: `String?`
- `arg1`: `Node?`

Returns: `Void`

### `timelineNew`

```norm
Timeline timelineNew()
```

Returns: `Timeline`

## `ui.desktop.kit.internal`

Source: `internal/Tooltip.norm`

### `Tooltip`

```norm
class Tooltip implements AutoCloseable
```

#### `Tooltip`

```norm
Tooltip(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `hide`

```norm
Void hide()
```

Returns: `Void`

#### `isShowing`

```norm
Boolean isShowing()
```

Returns: `Boolean`

#### `show`

```norm
Void show()
```

Returns: `Void`

### `tooltipNew`

```norm
Tooltip tooltipNew(Node? arg0, String? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `String?`

Returns: `Tooltip`

## `ui.desktop.kit.internal`

Source: `internal/Tour.norm`

### `Tour`

```norm
class Tour implements AutoCloseable
```

#### `Tour`

```norm
Tour(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getIndex`

```norm
Integer getIndex()
```

Returns: `Integer`

#### `next`

```norm
Void next()
```

Returns: `Void`

#### `previous`

```norm
Void previous()
```

Returns: `Void`

#### `start`

```norm
Void start()
```

Returns: `Void`

### `tourNew`

```norm
Tour tourNew(JavaList<TourStep>? arg0)
```

Parameters:

- `arg0`: `JavaList<TourStep>?`

Returns: `Tour`

## `ui.desktop.kit.internal`

Source: `internal/TourStep.norm`

### `TourStep`

```norm
class TourStep extends Record
```

#### `TourStep`

```norm
TourStep(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

### `tourStepNew`

```norm
TourStep tourStepNew(Node? arg0, String? arg1, String? arg2)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `String?`
- `arg2`: `String?`

Returns: `TourStep`

## `ui.desktop.kit.internal`

Source: `internal/Transfer.norm`

### `Transfer`

```norm
class Transfer<T> extends HBox implements EventTarget, Styleable
```

Type parameters:

- `T`

#### `Transfer`

```norm
Transfer(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getAvailableItems`

```norm
ObservableList<T>? getAvailableItems()
```

Returns: `ObservableList<T>?`

#### `getSelectedItems`

```norm
ObservableList<T>? getSelectedItems()
```

Returns: `ObservableList<T>?`

#### `remove`

```norm
Void remove(T? arg0)
```

Parameters:

- `arg0`: `T?`

Returns: `Void`

#### `select`

```norm
Void select(T? arg0)
```

Parameters:

- `arg0`: `T?`

Returns: `Void`

### `transferNew`

```norm
Transfer<T> transferNew<T>(JavaList<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `JavaList<T>?`

Returns: `Transfer<T>`

## `ui.desktop.kit.internal`

Source: `internal/Tree.norm`

### `Tree`

```norm
class Tree<T> extends TreeView<T> implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `Tree`

```norm
Tree(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getCheckedValues`

```norm
JavaList<T>? getCheckedValues()
```

Returns: `JavaList<T>?`

#### `getRoot`

```norm
TreeItem<T>? getRoot()
```

Returns: `TreeItem<T>?`

#### `setCheckable`

```norm
Void setCheckable(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setLazyChildren`

```norm
Void setLazyChildren(Function<CompletableFuture<JavaList<T>>?(T?)>? arg0)
```

Parameters:

- `arg0`: `Function<CompletableFuture<JavaList<T>>?(T?)>?`

Returns: `Void`

### `treeNew`

```norm
Tree<T> treeNew<T>(T? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `T?`

Returns: `Tree<T>`

## `ui.desktop.kit.internal`

Source: `internal/TreeCheckLink.norm`

### `TreeCheckLink`

```norm
class TreeCheckLink<T> implements AutoCloseable
```

Type parameters:

- `T`

#### `TreeCheckLink`

```norm
TreeCheckLink(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `unbind`

```norm
Void unbind()
```

Returns: `Void`

#### `update`

```norm
Void update(JavaList<T>? arg0, Function<Void(JavaList<T>?)>? arg1)
```

Parameters:

- `arg0`: `JavaList<T>?`
- `arg1`: `Function<Void(JavaList<T>?)>?`

Returns: `Void`

### `treeCheckLinkNew`

```norm
TreeCheckLink<T> treeCheckLinkNew<T>(Tree<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Tree<T>?`

Returns: `TreeCheckLink<T>`

## `ui.desktop.kit.internal`

Source: `internal/TreeSelect.norm`

### `TreeSelect`

```norm
class TreeSelect<T> extends HBox implements EventTarget, Styleable
```

Type parameters:

- `T`

#### `TreeSelect`

```norm
TreeSelect(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getRootItem`

```norm
TreeItem<T>? getRootItem()
```

Returns: `TreeItem<T>?`

#### `getSelectedItem`

```norm
TreeItem<T>? getSelectedItem()
```

Returns: `TreeItem<T>?`

#### `getSelectedValue`

```norm
T? getSelectedValue()
```

Returns: `T?`

#### `select`

```norm
Void select(TreeItem<T>? arg0)
```

Parameters:

- `arg0`: `TreeItem<T>?`

Returns: `Void`

#### `valueProperty`

```norm
ReadOnlyObjectProperty<T>? valueProperty()
```

Returns: `ReadOnlyObjectProperty<T>?`

### `treeSelectNew`

```norm
TreeSelect<T> treeSelectNew<T>(TreeItem<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `TreeItem<T>?`

Returns: `TreeSelect<T>`

## `ui.desktop.kit.internal`

Source: `internal/TreeSelectionLink.norm`

### `TreeSelectionLink`

```norm
class TreeSelectionLink<T> implements AutoCloseable
```

Type parameters:

- `T`

#### `TreeSelectionLink`

```norm
TreeSelectionLink(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `unbind`

```norm
Void unbind()
```

Returns: `Void`

#### `update`

```norm
Void update(T? arg0, Function<Void(T?)>? arg1)
```

Parameters:

- `arg0`: `T?`
- `arg1`: `Function<Void(T?)>?`

Returns: `Void`

### `treeSelectionLinkNew`

```norm
TreeSelectionLink<T> treeSelectionLinkNew<T>(Tree<T>? arg0)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Tree<T>?`

Returns: `TreeSelectionLink<T>`

## `ui.desktop.kit.internal`

Source: `internal/Typography.norm`

### `Typography`

```norm
class Typography extends Label implements Skinnable, EventTarget, Styleable
```

#### `Typography`

```norm
Typography(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `beginEdit`

```norm
Void beginEdit()
```

Returns: `Void`

#### `cancelEdit`

```norm
Void cancelEdit()
```

Returns: `Void`

#### `commitEdit`

```norm
Void commitEdit()
```

Returns: `Void`

#### `getText`

```norm
String? getText()
```

Returns: `String?`

#### `setCopyable`

```norm
Void setCopyable(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setEditable`

```norm
Void setEditable(Boolean arg0)
```

Parameters:

- `arg0`: `Boolean`

Returns: `Void`

#### `setOnEditCommit`

```norm
Void setOnEditCommit(Function<Void(ActionEvent?)>? arg0)
```

Parameters:

- `arg0`: `Function<Void(ActionEvent?)>?`

Returns: `Void`

#### `setText`

```norm
Void setText(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Void`

### `typographyNew`

```norm
Typography typographyNew()
```

Returns: `Typography`

### `typographyNew`

```norm
Typography typographyNew(String? arg0)
```

Parameters:

- `arg0`: `String?`

Returns: `Typography`

## `ui.desktop.kit.internal`

Source: `internal/Upload.norm`

### `Upload`

```norm
class Upload extends VBox implements AutoCloseable, EventTarget, Styleable
```

#### `Upload`

```norm
Upload(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `addFile`

```norm
UploadItem? addFile(File? arg0)
```

Parameters:

- `arg0`: `File?`

Returns: `UploadItem?`

#### `cancel`

```norm
Void cancel(UploadItem? arg0)
```

Parameters:

- `arg0`: `UploadItem?`

Returns: `Void`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `getItems`

```norm
ObservableList<UploadItem>? getItems()
```

Returns: `ObservableList<UploadItem>?`

#### `setUploader`

```norm
Void setUploader(Function<CompletableFuture<JavaVoid>?(File?)>? arg0)
```

Parameters:

- `arg0`: `Function<CompletableFuture<JavaVoid>?(File?)>?`

Returns: `Void`

#### `upload`

```norm
Void upload(UploadItem? arg0)
```

Parameters:

- `arg0`: `UploadItem?`

Returns: `Void`

### `uploadNew`

```norm
Upload uploadNew()
```

Returns: `Upload`

## `ui.desktop.kit.internal`

Source: `internal/UploadItem.norm`

### `UploadItem`

```norm
class UploadItem
```

#### `UploadItem`

```norm
UploadItem(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `getFile`

```norm
File? getFile()
```

Returns: `File?`

#### `getProgress`

```norm
Double getProgress()
```

Returns: `Double`

#### `getStatus`

```norm
UploadStatus? getStatus()
```

Returns: `UploadStatus?`

#### `progressProperty`

```norm
ReadOnlyDoubleProperty? progressProperty()
```

Returns: `ReadOnlyDoubleProperty?`

#### `statusProperty`

```norm
ReadOnlyObjectProperty<UploadStatus>? statusProperty()
```

Returns: `ReadOnlyObjectProperty<UploadStatus>?`

## `ui.desktop.kit.internal`

Source: `internal/UploadStatus.norm`

### `UploadStatus`

```norm
enum UploadStatus
```

#### `CANCELLED`

```norm
CANCELLED
```

#### `COMPLETE`

```norm
COMPLETE
```

#### `FAILED`

```norm
FAILED
```

#### `READY`

```norm
READY
```

#### `UPLOADING`

```norm
UPLOADING
```

## `ui.desktop.kit.internal`

Source: `internal/Util.norm`

### `Util`

```norm
class Util
```

#### `Util`

```norm
Util(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

### `utilApp`

```norm
App? utilApp(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `App?`

### `utilCloseNode`

```norm
Void utilCloseNode(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

### `utilEmptyItems`

```norm
JavaList<T>? utilEmptyItems<T>()
```

Type parameters:

- `T`

Returns: `JavaList<T>?`

### `utilStyle`

```norm
Void utilStyle(Node? arg0, String? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `String?`

Returns: `Void`

## `ui.desktop.kit.internal`

Source: `internal/ValueLink.norm`

### `ValueLink`

```norm
class ValueLink<T> implements AutoCloseable
```

Type parameters:

- `T`

#### `ValueLink`

```norm
ValueLink(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `close`

```norm
Void close()
```

Returns: `Void`

#### `node`

```norm
Node? node()
```

Returns: `Node?`

#### `unbind`

```norm
Void unbind()
```

Returns: `Void`

#### `update`

```norm
Void update(T? arg0, Function<Void(T?)>? arg1)
```

Parameters:

- `arg0`: `T?`
- `arg1`: `Function<Void(T?)>?`

Returns: `Void`

### `valueLinkNew`

```norm
ValueLink<T> valueLinkNew<T>(Node? arg0, Property<T>? arg1)
```

Type parameters:

- `T`

Parameters:

- `arg0`: `Node?`
- `arg1`: `Property<T>?`

Returns: `ValueLink<T>`

### `valueLinkChecked`

```norm
ValueLink<Boolean>? valueLinkChecked(CheckBox? arg0)
```

Parameters:

- `arg0`: `CheckBox?`

Returns: `ValueLink<Boolean>?`

### `valueLinkText`

```norm
ValueLink<String>? valueLinkText(TextInputControl? arg0)
```

Parameters:

- `arg0`: `TextInputControl?`

Returns: `ValueLink<String>?`

### `valueLinkToggled`

```norm
ValueLink<Boolean>? valueLinkToggled(ToggleButton? arg0)
```

Parameters:

- `arg0`: `ToggleButton?`

Returns: `ValueLink<Boolean>?`

## `ui.desktop.kit.internal`

Source: `internal/Watermark.norm`

### `Watermark`

```norm
class Watermark extends StackPane implements EventTarget, Styleable
```

#### `Watermark`

```norm
Watermark(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

#### `colorProperty`

```norm
ObjectProperty<Color>? colorProperty()
```

Returns: `ObjectProperty<Color>?`

#### `getImage`

```norm
Image? getImage()
```

Returns: `Image?`

#### `setContent`

```norm
Void setContent(Node? arg0)
```

Parameters:

- `arg0`: `Node?`

Returns: `Void`

#### `setImage`

```norm
Void setImage(Image? arg0)
```

Parameters:

- `arg0`: `Image?`

Returns: `Void`

#### `textProperty`

```norm
StringProperty? textProperty()
```

Returns: `StringProperty?`

### `watermarkNew`

```norm
Watermark watermarkNew(Node? arg0, String? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `String?`

Returns: `Watermark`

### `watermarkNew`

```norm
Watermark watermarkNew(Node? arg0, Image? arg1)
```

Parameters:

- `arg0`: `Node?`
- `arg1`: `Image?`

Returns: `Watermark`

## `ui.desktop.kit.javafx.animation`

Source: `javafx/animation/Interpolatable.norm`

### `Interpolatable`

```norm
interface Interpolatable<T>
```

Type parameters:

- `T`

## `ui.desktop.kit.javafx.beans.binding`

Source: `javafx/beans/binding/DoubleExpression.norm`

### `DoubleExpression`

```norm
class DoubleExpression extends NumberExpressionBase implements ObservableDoubleValue, NumberExpression
```

#### `DoubleExpression`

```norm
DoubleExpression(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.binding`

Source: `javafx/beans/binding/IntegerExpression.norm`

### `IntegerExpression`

```norm
class IntegerExpression extends NumberExpressionBase implements ObservableIntegerValue, NumberExpression
```

#### `IntegerExpression`

```norm
IntegerExpression(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.binding`

Source: `javafx/beans/binding/NumberExpression.norm`

### `NumberExpression`

```norm
interface NumberExpression extends ObservableNumberValue
```

## `ui.desktop.kit.javafx.beans.binding`

Source: `javafx/beans/binding/NumberExpressionBase.norm`

### `NumberExpressionBase`

```norm
class NumberExpressionBase implements NumberExpression
```

#### `NumberExpressionBase`

```norm
NumberExpressionBase(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.binding`

Source: `javafx/beans/binding/ObjectExpression.norm`

### `ObjectExpression`

```norm
class ObjectExpression<T> implements ObservableObjectValue<T>
```

Type parameters:

- `T`

#### `ObjectExpression`

```norm
ObjectExpression(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.property`

Source: `javafx/beans/property/DoubleProperty.norm`

### `DoubleProperty`

```norm
class DoubleProperty extends ReadOnlyDoubleProperty implements Property<Number>, WritableDoubleValue, ReadOnlyProperty<Number>, ObservableDoubleValue, NumberExpression
```

#### `DoubleProperty`

```norm
DoubleProperty(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.property`

Source: `javafx/beans/property/IntegerProperty.norm`

### `IntegerProperty`

```norm
class IntegerProperty extends ReadOnlyIntegerProperty implements Property<Number>, WritableIntegerValue, ReadOnlyProperty<Number>, ObservableIntegerValue, NumberExpression
```

#### `IntegerProperty`

```norm
IntegerProperty(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.property`

Source: `javafx/beans/property/ObjectProperty.norm`

### `ObjectProperty`

```norm
class ObjectProperty<T> extends ReadOnlyObjectProperty<T> implements Property<T>, WritableObjectValue<T>, ReadOnlyProperty<T>, ObservableObjectValue<T>
```

Type parameters:

- `T`

#### `ObjectProperty`

```norm
ObjectProperty(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.property`

Source: `javafx/beans/property/Property.norm`

### `Property`

```norm
interface Property<T> extends ReadOnlyProperty<T>, WritableValue<T>
```

Type parameters:

- `T`

## `ui.desktop.kit.javafx.beans.property`

Source: `javafx/beans/property/ReadOnlyDoubleProperty.norm`

### `ReadOnlyDoubleProperty`

```norm
class ReadOnlyDoubleProperty extends DoubleExpression implements ReadOnlyProperty<Number>, ObservableDoubleValue, NumberExpression
```

#### `ReadOnlyDoubleProperty`

```norm
ReadOnlyDoubleProperty(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.property`

Source: `javafx/beans/property/ReadOnlyIntegerProperty.norm`

### `ReadOnlyIntegerProperty`

```norm
class ReadOnlyIntegerProperty extends IntegerExpression implements ReadOnlyProperty<Number>, ObservableIntegerValue, NumberExpression
```

#### `ReadOnlyIntegerProperty`

```norm
ReadOnlyIntegerProperty(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.property`

Source: `javafx/beans/property/ReadOnlyObjectProperty.norm`

### `ReadOnlyObjectProperty`

```norm
class ReadOnlyObjectProperty<T> extends ObjectExpression<T> implements ReadOnlyProperty<T>, ObservableObjectValue<T>
```

Type parameters:

- `T`

#### `ReadOnlyObjectProperty`

```norm
ReadOnlyObjectProperty(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.beans.property`

Source: `javafx/beans/property/ReadOnlyProperty.norm`

### `ReadOnlyProperty`

```norm
interface ReadOnlyProperty<T> extends ObservableValue<T>
```

Type parameters:

- `T`

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/ObservableDoubleValue.norm`

### `ObservableDoubleValue`

```norm
interface ObservableDoubleValue extends ObservableNumberValue
```

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/ObservableIntegerValue.norm`

### `ObservableIntegerValue`

```norm
interface ObservableIntegerValue extends ObservableNumberValue
```

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/ObservableNumberValue.norm`

### `ObservableNumberValue`

```norm
interface ObservableNumberValue extends ObservableValue<Number>
```

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/ObservableObjectValue.norm`

### `ObservableObjectValue`

```norm
interface ObservableObjectValue<T> extends ObservableValue<T>
```

Type parameters:

- `T`

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/WritableDoubleValue.norm`

### `WritableDoubleValue`

```norm
interface WritableDoubleValue extends WritableNumberValue
```

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/WritableIntegerValue.norm`

### `WritableIntegerValue`

```norm
interface WritableIntegerValue extends WritableNumberValue
```

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/WritableNumberValue.norm`

### `WritableNumberValue`

```norm
interface WritableNumberValue extends WritableValue<Number>
```

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/WritableObjectValue.norm`

### `WritableObjectValue`

```norm
interface WritableObjectValue<T> extends WritableValue<T>
```

Type parameters:

- `T`

## `ui.desktop.kit.javafx.beans.value`

Source: `javafx/beans/value/WritableValue.norm`

### `WritableValue`

```norm
interface WritableValue<T>
```

Type parameters:

- `T`

## `ui.desktop.kit.javafx.event`

Source: `javafx/event/ActionEvent.norm`

### `ActionEvent`

```norm
class ActionEvent extends Event implements Cloneable, Serializable
```

#### `ActionEvent`

```norm
ActionEvent(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.geometry`

Source: `javafx/geometry/Side.norm`

### `Side`

```norm
enum Side
```

#### `BOTTOM`

```norm
BOTTOM
```

#### `LEFT`

```norm
LEFT
```

#### `RIGHT`

```norm
RIGHT
```

#### `TOP`

```norm
TOP
```

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/ButtonBase.norm`

### `ButtonBase`

```norm
class ButtonBase extends Labeled implements Skinnable, EventTarget, Styleable
```

#### `ButtonBase`

```norm
ButtonBase(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/ComboBox.norm`

### `ComboBox`

```norm
class ComboBox<T> extends ComboBoxBase<T> implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `ComboBox`

```norm
ComboBox(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/ComboBoxBase.norm`

### `ComboBoxBase`

```norm
class ComboBoxBase<T> extends Control implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `ComboBoxBase`

```norm
ComboBoxBase(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/Control.norm`

### `Control`

```norm
class Control extends Region implements Skinnable, EventTarget, Styleable
```

#### `Control`

```norm
Control(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/DatePicker.norm`

### `DatePicker`

```norm
class DatePicker extends ComboBoxBase<LocalDate> implements Skinnable, EventTarget, Styleable
```

#### `DatePicker`

```norm
DatePicker(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/IndexRange.norm`

### `IndexRange`

```norm
class IndexRange
```

#### `IndexRange`

```norm
IndexRange(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/ListView.norm`

### `ListView`

```norm
class ListView<T> extends Control implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `ListView`

```norm
ListView(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/Menu.norm`

### `Menu`

```norm
class Menu extends MenuItem implements EventTarget, Styleable
```

#### `Menu`

```norm
Menu(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/MenuBar.norm`

### `MenuBar`

```norm
class MenuBar extends Control implements Skinnable, EventTarget, Styleable
```

#### `MenuBar`

```norm
MenuBar(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/MenuItem.norm`

### `MenuItem`

```norm
class MenuItem implements EventTarget, Styleable
```

#### `MenuItem`

```norm
MenuItem(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/MultipleSelectionModel.norm`

### `MultipleSelectionModel`

```norm
class MultipleSelectionModel<T> extends SelectionModel<T>
```

Type parameters:

- `T`

#### `MultipleSelectionModel`

```norm
MultipleSelectionModel(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/ProgressBar.norm`

### `ProgressBar`

```norm
class ProgressBar extends ProgressIndicator implements Skinnable, EventTarget, Styleable
```

#### `ProgressBar`

```norm
ProgressBar(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/ProgressIndicator.norm`

### `ProgressIndicator`

```norm
class ProgressIndicator extends Control implements Skinnable, EventTarget, Styleable
```

#### `ProgressIndicator`

```norm
ProgressIndicator(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/RadioButton.norm`

### `RadioButton`

```norm
class RadioButton extends ToggleButton implements Toggle, Skinnable, EventTarget, Styleable
```

#### `RadioButton`

```norm
RadioButton(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/SelectionModel.norm`

### `SelectionModel`

```norm
class SelectionModel<T>
```

Type parameters:

- `T`

#### `SelectionModel`

```norm
SelectionModel(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/Separator.norm`

### `Separator`

```norm
class Separator extends Control implements Skinnable, EventTarget, Styleable
```

#### `Separator`

```norm
Separator(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/Skinnable.norm`

### `Skinnable`

```norm
interface Skinnable
```

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/Slider.norm`

### `Slider`

```norm
class Slider extends Control implements Skinnable, EventTarget, Styleable
```

#### `Slider`

```norm
Slider(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/Spinner.norm`

### `Spinner`

```norm
class Spinner<T> extends Control implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `Spinner`

```norm
Spinner(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/SplitPane.norm`

### `SplitPane`

```norm
class SplitPane extends Control implements Skinnable, EventTarget, Styleable
```

#### `SplitPane`

```norm
SplitPane(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/TableColumn.norm`

### `TableColumn`

```norm
class TableColumn<S, T> extends TableColumnBase<S, T> implements EventTarget, Styleable
```

Type parameters:

- `S`
- `T`

#### `TableColumn`

```norm
TableColumn(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/TableColumnBase.norm`

### `TableColumnBase`

```norm
class TableColumnBase<S, T> implements EventTarget, Styleable
```

Type parameters:

- `S`
- `T`

#### `TableColumnBase`

```norm
TableColumnBase(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/TableView.norm`

### `TableView`

```norm
class TableView<S> extends Control implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `S`

#### `TableView`

```norm
TableView(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/TitledPane.norm`

### `TitledPane`

```norm
class TitledPane extends Labeled implements Skinnable, EventTarget, Styleable
```

#### `TitledPane`

```norm
TitledPane(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/Toggle.norm`

### `Toggle`

```norm
interface Toggle
```

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/ToggleButton.norm`

### `ToggleButton`

```norm
class ToggleButton extends ButtonBase implements Toggle, Skinnable, EventTarget, Styleable
```

#### `ToggleButton`

```norm
ToggleButton(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/ToggleGroup.norm`

### `ToggleGroup`

```norm
class ToggleGroup
```

#### `ToggleGroup`

```norm
ToggleGroup(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/TreeItem.norm`

### `TreeItem`

```norm
class TreeItem<T> implements EventTarget
```

Type parameters:

- `T`

#### `TreeItem`

```norm
TreeItem(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.control`

Source: `javafx/scene/control/TreeView.norm`

### `TreeView`

```norm
class TreeView<T> extends Control implements Skinnable, EventTarget, Styleable
```

Type parameters:

- `T`

#### `TreeView`

```norm
TreeView(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.image`

Source: `javafx/scene/image/Image.norm`

### `Image`

```norm
class Image
```

#### `Image`

```norm
Image(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.image`

Source: `javafx/scene/image/ImageView.norm`

### `ImageView`

```norm
class ImageView extends Node implements EventTarget, Styleable
```

#### `ImageView`

```norm
ImageView(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.layout`

Source: `javafx/scene/layout/BorderPane.norm`

### `BorderPane`

```norm
class BorderPane extends Pane implements EventTarget, Styleable
```

#### `BorderPane`

```norm
BorderPane(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.layout`

Source: `javafx/scene/layout/GridPane.norm`

### `GridPane`

```norm
class GridPane extends Pane implements EventTarget, Styleable
```

#### `GridPane`

```norm
GridPane(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.paint`

Source: `javafx/scene/paint/Color.norm`

### `Color`

```norm
class Color extends Paint implements Interpolatable<Paint>
```

#### `Color`

```norm
Color(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.paint`

Source: `javafx/scene/paint/Paint.norm`

### `Paint`

```norm
class Paint implements Interpolatable<Paint>
```

#### `Paint`

```norm
Paint(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.shape`

Source: `javafx/scene/shape/Shape.norm`

### `Shape`

```norm
class Shape extends Node implements EventTarget, Styleable
```

#### `Shape`

```norm
Shape(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.scene.text`

Source: `javafx/scene/text/Text.norm`

### `Text`

```norm
class Text extends Shape implements EventTarget, Styleable
```

#### `Text`

```norm
Text(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.javafx.util`

Source: `javafx/util/Duration.norm`

### `Duration`

```norm
class Duration implements Comparable<Duration>, Serializable
```

#### `Duration`

```norm
Duration(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit`

Source: `layout.norm`

### `Divider`

```norm
value Divider implements Widget
```

#### `vertical`

```norm
Boolean vertical
```

Type: `Boolean`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Splitter`

```norm
value Splitter implements Widget
```

#### `children`

```norm
List<Widget> children
```

Type: `List<Widget>`

#### `vertical`

```norm
Boolean vertical
```

Type: `Boolean`

#### `dividerPosition`

```norm
Double dividerPosition
```

Type: `Double`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

## `ui.desktop.kit`

Source: `navigation.norm`

### `AnchorSection`

```norm
value AnchorSection
```

#### `title`

```norm
String title
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

### `Anchor`

```norm
value Anchor implements Widget
```

#### `sections`

```norm
List<AnchorSection> sections
```

Type: `List<AnchorSection>`

#### `selected`

```norm
Binding<Integer>? selected
```

Type: `Binding<Integer>?`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `BreadcrumbItem`

```norm
value BreadcrumbItem
```

#### `text`

```norm
String text
```

Type: `String`

#### `action`

```norm
Function<Void()> action
```

Type: `Function<Void()>`

### `Breadcrumb`

```norm
value Breadcrumb implements Widget
```

#### `items`

```norm
List<BreadcrumbItem> items
```

Type: `List<BreadcrumbItem>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Dropdown`

```norm
value Dropdown implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `MenuItem`

```norm
value MenuItem
```

#### `text`

```norm
String text
```

Type: `String`

#### `action`

```norm
Function<Void()> action
```

Type: `Function<Void()>`

### `MenuGroup`

```norm
value MenuGroup
```

#### `title`

```norm
String title
```

Type: `String`

#### `items`

```norm
List<MenuItem> items
```

Type: `List<MenuItem>`

### `Menu`

```norm
value Menu implements Widget
```

#### `groups`

```norm
List<MenuGroup> groups
```

Type: `List<MenuGroup>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Pagination`

```norm
value Pagination implements Widget
```

#### `totalItems`

```norm
Integer totalItems
```

Type: `Integer`

#### `currentPage`

```norm
Binding<Integer> currentPage
```

Type: `Binding<Integer>`

#### `pageSize`

```norm
Integer pageSize
```

Type: `Integer`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Steps`

```norm
value Steps implements Widget
```

#### `titles`

```norm
List<String> titles
```

Type: `List<String>`

#### `currentStep`

```norm
Binding<Integer> currentStep
```

Type: `Binding<Integer>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Tab`

```norm
value Tab
```

#### `title`

```norm
String title
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `scroll`

```norm
Boolean scroll
```

Type: `Boolean`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

### `Tabs`

```norm
value Tabs implements Widget
```

#### `tabs`

```norm
List<Tab> tabs
```

Type: `List<Tab>`

#### `selected`

```norm
Binding<Integer> selected
```

Type: `Binding<Integer>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

## `ui.desktop.kit`

Source: `notices.norm`

### `Message`

```norm
value Message implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `open`

```norm
Binding<Boolean> open
```

Type: `Binding<Boolean>`

#### `duration`

```norm
Double duration
```

Type: `Double`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Notification`

```norm
value Notification implements Widget
```

#### `title`

```norm
String title
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `open`

```norm
Binding<Boolean> open
```

Type: `Binding<Boolean>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

## `ui.desktop.kit.org.kordamp.ikonli.javafx`

Source: `org/kordamp/ikonli/javafx/FontIcon.norm`

### `FontIcon`

```norm
class FontIcon extends Text implements Icon, EventTarget, Styleable
```

#### `FontIcon`

```norm
FontIcon(__JarBindingToken token)
```

Parameters:

- `token`: `__JarBindingToken`

## `ui.desktop.kit.org.kordamp.ikonli.javafx`

Source: `org/kordamp/ikonli/javafx/Icon.norm`

### `Icon`

```norm
interface Icon extends Styleable
```

## `ui.desktop.kit`

Source: `status.norm`

### `Alert`

```norm
value Alert implements Widget
```

#### `title`

```norm
String title
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `closable`

```norm
Boolean closable
```

Type: `Boolean`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Result`

```norm
value Result implements Widget
```

#### `title`

```norm
String title
```

Type: `String`

#### `description`

```norm
String description
```

Type: `String`

#### `actions`

```norm
List<Widget> actions
```

Type: `List<Widget>`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `ProgressValue`

```norm
enum ProgressValue
```

#### `Indeterminate`

```norm
Indeterminate
```

#### `Fraction`

```norm
Fraction(Double fraction)
```

Parameters:

- `fraction`: `Double`

#### `Work`

```norm
Work(Integer completed, Integer total)
```

Parameters:

- `completed`: `Integer`
- `total`: `Integer`

### `Progress`

```norm
value Progress implements Widget
```

#### `value`

```norm
ProgressValue value
```

Type: `ProgressValue`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Skeleton`

```norm
value Skeleton implements Widget
```

#### `lines`

```norm
Integer lines
```

Type: `Integer`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Spin`

```norm
value Spin implements Widget
```

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `spinning`

```norm
Boolean spinning
```

Type: `Boolean`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Watermark`

```norm
value Watermark implements Widget
```

#### `text`

```norm
String text
```

Type: `String`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `BorderBeam`

```norm
value BorderBeam implements Widget
```

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `animated`

```norm
Boolean animated
```

Type: `Boolean`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

### `Affix`

```norm
value Affix implements Widget
```

#### `fixed`

```norm
Widget fixed
```

Type: `Widget`

#### `content`

```norm
Widget content
```

Type: `Widget`

#### `key`

```norm
NodeKey? key
```

Type: `NodeKey?`

#### `build`

```norm
Widget build()
```

Returns: `Widget`

