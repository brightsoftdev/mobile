//
//  Category.m
//  Nellodee
//
//  Created by Ada Hopper on 09/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import "Category.h"


@implementation Category
@synthesize title, subcategories;

- (void)dealloc {
	[title release];
	[subcategories release];
	[super dealloc];
}

@end
