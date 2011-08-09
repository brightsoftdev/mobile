//
//  Category.h
//  Nellodee
//
//  Created by Ada Hopper on 09/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface Category : NSObject {
	NSString *title;
	NSMutableArray *subcategories;
}
@property (nonatomic,retain) NSString *title;
@property (nonatomic,retain) NSMutableArray *subcategories;

@end

